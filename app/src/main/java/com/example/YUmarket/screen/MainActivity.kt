package com.example.YUmarket.screen

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentProviderClient
import android.content.Context
import android.content.pm.ConfigurationInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationProvider
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.view.isGone
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.example.YUmarket.MyApplication
import com.example.YUmarket.R
import com.example.YUmarket.data.entity.location.LocationLatLngEntity
import com.example.YUmarket.databinding.ActivityMainBinding
import com.example.YUmarket.screen.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity
    : BaseActivity<ActivityMainBinding>() {

    companion object {
        val locationPermissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

    }


    // Navigation에 사용할 Controller
    private val navController by lazy {
        val hostContainer =
            supportFragmentManager
                .findFragmentById(R.id.fragmentContainer)
                    as NavHost

        hostContainer.navController
    }

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val responsePermissions = permissions.entries.filter {
                it.key in locationPermissions
            }

            if (responsePermissions.filter { it.value == true }.size == locationPermissions.size) {
                setLocationListener()
            } else {
                Toast.makeText(this, "no", Toast.LENGTH_SHORT).show()
            }
        }

//    private val changeLocationLauncher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { results ->
//            result.data?.getParcelableExtra<MapSearchInfoEntity>(MY_LOCATION_KEY)?.let { myLocationInfo ->
//                viewModel.loadReverseGeoInformation(myLocationInfo.locationLatLng)
//            }
//        }

    private lateinit var locationManager: LocationManager

    private lateinit var myLocationListener: MyLocationListener

    private val viewModel by viewModel<MainViewModel>()


//    val currentNightMode = configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
//    when (currentNightMode) {
//        Configuration.UI_MODE_NIGHT_NO -> {} // Night mode is not active, we're using the light theme
//        Configuration.UI_MODE_NIGHT_YES -> {} // Night mode is active, we're using dark theme
//    }


    private fun checkLocation(): Boolean {
        val location: Location?
        if (ActivityCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            binding.locationTitleTextView.text = location?.toString()
            return true
        }
        return false
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


    override fun observeData() = with(binding) {
        viewModel.locationData.observe(this@MainActivity) {
            when (it) {
                is MainState.Uninitialized -> {
                    getMyLocation()
                }

                is MainState.Loading -> {

                }

                is MainState.Success -> {
                    locationLoading.isGone = true
                    locationTitleTextView.text = it.mapSearchInfoEntity.fullAddress
                    MyApplication.prefs.myEditText = locationTitleTextView.text.toString()
                }

                is MainState.Error -> {
                    locationTitleTextView.text = getString(it.errorMessage)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun initViews() = with(binding) {

        // 22.01.19 BottomNavigationView의 동작을 Controller를 이용하여 설정
        // by 정남진
        bottomNav.setupWithNavController(navController)

        binding.locationTitleTextView.setOnClickListener {

        }


//        locationTitleTextView.setOnClickListener {
//            viewModel.getMapSearchInfo()?.let { mapInfo ->
//                changeLocationLauncher.launch(
//                    MyLocationActivity.newIntent(
//                        requireContext(), mapInfo
//                    )
//                )
//            }
//        }
    }


    private fun getMyLocation() {
        if (::locationManager.isInitialized.not()) {
            locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        }
        val isGpsEnable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if (isGpsEnable) {
            permissionLauncher.launch(locationPermissions)
        }
    }

    @Suppress("MissingPermission")
    private fun setLocationListener() {
        val minTime: Long = 1500
        val minDistance = 100f

        if (::myLocationListener.isInitialized.not()) {
            myLocationListener = MyLocationListener()
        }

        with(locationManager) {
            requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime, minDistance, myLocationListener
            )

            requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                minTime, minDistance, myLocationListener
            )
        }
    }

    inner class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
//            binding.locationTitleTextView.text = "${location.latitude}, ${location.longitude}"
            viewModel.getReverseGeoInformation(
                LocationLatLngEntity(
                    latitude = location.latitude,
                    longitude = location.longitude
                )
            )

            removeLocationListener()
        }

        private fun removeLocationListener() {
            if (::locationManager.isInitialized && ::myLocationListener.isInitialized) {
                locationManager.removeUpdates(myLocationListener)
            }
        }
    }
}