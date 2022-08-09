package com.example.theaudiodb.di

import okhttp3.Request
import org.koin.dsl.module

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