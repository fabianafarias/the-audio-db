package com.example.theaudiodb.model.repository

import org.koin.core.component.KoinComponent

class LovedRepositoryImpl(): LovedRepository, KoinComponent {
    override suspend fun getMostLoved(): LovedRepositoryResult {
        TODO("Not yet implemented")
    }

}