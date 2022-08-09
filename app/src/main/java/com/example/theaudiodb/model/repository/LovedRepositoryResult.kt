package com.example.theaudiodb.model.repository

import com.example.theaudiodb.model.remote.dto.LovedItemDTO

sealed class LovedRepositoryResult{
    data class Success(val lovedItem: LovedItemDTO) : LovedRepositoryResult()
    object Error: LovedRepositoryResult()
}
