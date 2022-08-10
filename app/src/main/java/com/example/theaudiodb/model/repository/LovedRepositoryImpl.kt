package com.example.theaudiodb.model.repository

import com.example.theaudiodb.model.remote.service.LovedApi
import com.example.theaudiodb.model.remote.service.LovedApiResult
import org.koin.core.component.KoinComponent

class LovedRepositoryImpl(private val lovedApi: LovedApi) : LovedRepository, KoinComponent {
    override suspend fun getMostLoved(): LovedRepositoryResult {
        when (val lovedApiResult = lovedApi.getMostLoved()) {
            LovedApiResult.Error -> {
                return LovedRepositoryResult.Error
            }
            is LovedApiResult.Success -> {
                lovedApiResult.lovedItem.let {
                    return LovedRepositoryResult.Success(it)
                }
            }
        }
    }


}