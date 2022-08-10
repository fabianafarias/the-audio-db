package com.example.theaudiodb.model.remote.service

import com.example.theaudiodb.model.remote.response.LovedListResponse
import retrofit2.Response
import retrofit2.http.GET



interface LovedService {
    @GET
    suspend fun getMostLoved(): Response<LovedListResponse>
}