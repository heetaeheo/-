package com.example.YUmarket.screen

import androidx.lifecycle.*
import com.example.YUmarket.util.provider.ResoucesProvider
import com.example.YUmarket.R
import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.data.entity.location.MapSearchInfoEntity
import com.example.YUmarket.data.repository.map.MapRepository
import com.example.YUmarket.screen.base.BaseViewModel
import com.example.YUmarket.util.SharedPreferences

import kotlinx.coroutines.launch

class MainViewModel(
    private val mapRepository: MapRepository,
    private val resourcesProvider: ResoucesProvider
) : BaseViewModel() {

    //    val mainStateLiveData = MutableLiveData<MainState>(MainState.Uninitialized)

    private val _locationData = MutableLiveData<MainState>(MainState.Uninitialized)
    val locationData: LiveData<MainState> = _locationData



    fun getMapSearchInfo() {
    }


    fun getReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ) = viewModelScope.launch {

        val currentLocation = locationLatLngEntity

        val addressInfo = mapRepository.getReverseGeoInformation(locationLatLngEntity)

        addressInfo?.let { addressInfoResult ->
            _locationData.value = MainState.Success(
                mapSearchInfoEntity = MapSearchInfoEntity(
                    fullAddress = addressInfoResult.fullAddress
                        ?: resourcesProvider.getString(R.string.no_address_info_found),
                    name = addressInfoResult.buildingName
                        ?: resourcesProvider.getString(R.string.no_address_info_found),
                    locationLatLng = currentLocation
                ),
                isLocationSame = false
            )
        } ?: MainState.Error(
            R.string.cannot_load_address_info
        )
    }
}