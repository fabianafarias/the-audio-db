package com.example.theaudiodb.di

import com.example.theaudiodb.model.remote.service.LovedApi
import com.example.theaudiodb.model.remote.service.LovedService
import com.example.theaudiodb.model.repository.LovedRepository
import com.example.theaudiodb.model.repository.LovedRepositoryImpl
import com.example.theaudiodb.ui.LovedViewModel
import okhttp3.Request
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val lovedDIModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://theaudiodb.p.rapidapi.com/mostloved.php?format=track")
            .build()
    }
}

val lovedServiceModule = module {
    single {
        get<Retrofit>().create(LovedService::class.java)
    }
}

val lovedApiModule = module {
    single<LovedApi> {
        LovedApi(get<LovedService>())
    }
}

val lovedRepositoryModule = module {
    single<LovedRepository> {
        LovedRepositoryImpl(get<LovedApi>())
    }
}

val lovedViewModelModule = module {
    single<LovedViewModel> {
        LovedViewModel(get<LovedRepository>())
    }
}






