package com.example.theaudiodb.model.remote.service

import com.example.theaudiodb.model.remote.dto.LovedItemDTO

sealed class LovedApiResult{
    data class Success(val lovedItem: LovedItemDTO) : LovedApiResult()
    object Error: LovedApiResult()
}