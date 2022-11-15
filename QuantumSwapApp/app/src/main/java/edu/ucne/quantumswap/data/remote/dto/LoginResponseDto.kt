package edu.ucne.quantumswap.data.remote.dto

data class LoginResponseDto (
    val UserId: String,
    val Name: String,
    val LastName:String,
    val Email:String,
    val Password: String,
    val SecretKey: String,
    val CreationDate:String,
    val ModificationDate:String,
    val Status: String,
        )