package com.example.theaudiodb.model.remote.service

class LovedApi(private val service: LovedService) {

    suspend fun getMostLoved(): LovedApiResult {
        try {
            val adviceResponse = service.getMostLoved()
            if (adviceResponse.isSuccessful) {
                adviceResponse.body()?.let {
                    it.loved.forEach {
                        return LovedApiResult.Success(lovedItem = it)
                    }
                }
            } else {
                return LovedApiResult.Error
            }
        } catch (
            e: Exception
        ) {
            e.printStackTrace()
            return LovedApiResult.Error
        }
        return LovedApiResult.Error
    }
}