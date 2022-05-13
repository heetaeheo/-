package com.example.YUmarket.di

import com.example.YUmarket.data.repository.map.DefaultMapRepository
import com.example.YUmarket.data.repository.map.MapRepository
import com.example.YUmarket.data.repository.myinfo.CSRepository
import com.example.YUmarket.data.repository.myinfo.DefaultCSRepository
import com.example.YUmarket.data.repository.restaurant.DefaultHomeRepository
import com.example.YUmarket.data.repository.restaurant.HomeRepository
import com.example.YUmarket.data.repository.suggest.DefaultSuggestRepository
import com.example.YUmarket.data.repository.suggest.SuggestRepository
import com.example.YUmarket.model.homelist.category.HomeListCategory
import com.example.YUmarket.screen.MainViewModel
import com.example.YUmarket.screen.home.homelist.HomeListViewModel
import com.example.YUmarket.screen.home.homemain.HomeMainViewModel
import com.example.YUmarket.screen.like.LikeViewModel
import com.example.YUmarket.screen.map.MapViewModel
import com.example.YUmarket.screen.myinfo.customerservice.list.CSCategory
import com.example.YUmarket.screen.myinfo.customerservice.list.CSListViewModel
import com.example.YUmarket.screen.orderlist.OrderListViewModel
import com.example.YUmarket.util.provider.DefaultResourcesProvider
import com.example.YUmarket.util.provider.ResoucesProvider
import com.example.YUmarket.widget.adapter.viewholder.suggest.SuggestViewHolder
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    factory { (homeListCategory: HomeListCategory) ->
        HomeListViewModel(homeListCategory, get())
    }
    /*  CSViewModel 추가  의존성 주입   factory추가
    *   csCategory factory                     */



    factory { (csCategory: CSCategory) ->
        CSListViewModel(csCategory,get())
    }



    viewModel {HomeMainViewModel(get(),get())}
    viewModel { MainViewModel(get(),get()) }
    viewModel { OrderListViewModel() }

    viewModel { LikeViewModel() }
    viewModel { MapViewModel() }


    single<HomeRepository> { DefaultHomeRepository() }
    single<SuggestRepository> {DefaultSuggestRepository()}
    // mockList 의존성 주입
    single<CSRepository>{ DefaultCSRepository(get()) }
    single<ResoucesProvider>{ DefaultResourcesProvider(androidContext())}

    single { buildOkHttpClient() }
    single { provideGsonConverterFactory() }

    single(named("map")) { provideMapRetrofit(get(), get()) }
    single { provideMapApiService(get(qualifier = named("map"))) }

    single<MapRepository> { DefaultMapRepository(get(), get()) }


    single { Dispatchers.IO }
    single { Dispatchers.Main }

    single { provideDB(androidContext()) }
    single { provideBasketDao(get()) }
    single { provideLikeItemDao(get()) }
    single { provideLikeMarketDao(get()) }


}