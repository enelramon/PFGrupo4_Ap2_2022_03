package edu.ucne.quantumswap.data.remote

import edu.ucne.quantumswap.data.remote.dto.LoginResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface QuantumSwapApi {

    @GET("users")
    suspend fun getLista():List<LoginResponseDto>

    @POST("users/login")
    suspend fun PostUsersLoginAPI(@Body loginResponseDto: LoginResponseDto): Response<LoginResponseDto>

    @PUT("users")
    suspend fun PutUsersAPI(@Body loginResponseDto: LoginResponseDto): Response<LoginResponseDto>
}