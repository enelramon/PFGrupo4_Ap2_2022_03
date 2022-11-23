package edu.ucne.quantumswap.data.remote.Dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginDto(
    val Email: String,
    val Password: String,
)