package com.example.theaudiodb.ui

import com.example.theaudiodb.model.remote.dto.LovedItemDTO

sealed class LovedViewModelResult {
    data class Success(val lovedItem: LovedItemDTO) : LovedViewModelResult()
    object Error: LovedViewModelResult()
}
