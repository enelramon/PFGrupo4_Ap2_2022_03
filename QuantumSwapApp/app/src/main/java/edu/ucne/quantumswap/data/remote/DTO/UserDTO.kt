package edu.ucne.quantumswap.data.remote.DTO

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class UserDTO(
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
    val userDto : UserDTO,
    val Exist: Boolean
)
