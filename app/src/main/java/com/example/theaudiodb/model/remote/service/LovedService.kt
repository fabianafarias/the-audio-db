package com.example.theaudiodb.model.remote.service

import com.example.theaudiodb.model.remote.response.LovedListResponse
import retrofit2.Response
import retrofit2.http.GET

const val API_KEY = "95bec82457msh57e787fa182e343p15a28fjsn50988daa2194"

interface LovedService {
    @GET
    suspend fun getMostLoved(): Response<LovedListResponse>
}