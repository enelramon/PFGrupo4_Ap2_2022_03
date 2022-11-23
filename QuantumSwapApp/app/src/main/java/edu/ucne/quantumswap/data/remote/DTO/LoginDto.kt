package edu.ucne.quantumswap.data.remote.DTO

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginDto(
    val Email: String,
    val Password: String,
)