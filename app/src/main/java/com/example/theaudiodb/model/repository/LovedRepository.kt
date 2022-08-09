package com.example.theaudiodb.model.repository

interface LovedRepository {
    suspend fun getMostLoved(): LovedRepositoryResult
}