package com.example.theaudiodb.model.remote.response

import com.example.theaudiodb.model.remote.dto.LovedItemDTO

data class LovedListResponse(
    val loved: List<LovedItemDTO>
)
