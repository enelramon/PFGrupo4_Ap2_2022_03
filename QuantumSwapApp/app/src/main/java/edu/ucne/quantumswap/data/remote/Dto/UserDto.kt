package edu.ucne.quantumswap.data.remote.Dto

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class UserDto(
    val UserId: Int,
    val Name: String,
    val LastName:String,
    val Email:String,
    val Password: String,
    val SecretKey: String,
    val CreationDate: String,
    val ModificationDate: String,
    val Status: Int
)

data class UserLoginDto(
    val userDto : UserDto,
    val Exist: Boolean
)
