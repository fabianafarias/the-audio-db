package com.example.theaudiodb.di

import com.example.theaudiodb.model.remote.service.LovedApi
import com.example.theaudiodb.model.remote.service.LovedService
import com.example.theaudiodb.model.repository.LovedRepository
import com.example.theaudiodb.model.repository.LovedRepositoryImpl
import okhttp3.Request
import org.koin.dsl.module
import retrofit2.Retrofit

val lovedDIModule = module {
    single<Request> {
        Request.Builder()
            .url("https://theaudiodb.p.rapidapi.com/mostloved.php?format=track")
            .get()
            .addHeader("X-RapidAPI-Key", "95bec82457msh57e787fa182e343p15a28fjsn50988daa2194")
            .addHeader("X-RapidAPI-Host", "theaudiodb.p.rapidapi.com")
            .build()
    }
}

val lovedServiceModule = module {
    single{
        get<Retrofit>().create(LovedService::class.java)
    }
}

val lovedApiModule = module {
    single<LovedApi>{
        LovedApi(get<LovedService>())
    }
}

val lovedRepositoryModule = module {
    single<LovedRepository>{
        LovedRepositoryImpl(get<LovedApi>())
    }
}






