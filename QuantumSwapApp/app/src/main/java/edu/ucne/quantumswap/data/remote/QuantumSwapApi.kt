package edu.ucne.quantumswap.data.remote

import edu.ucne.quantumswap.data.remote.dto.LoginResponseDto
import edu.ucne.quantumswap.data.remote.dto.ProductosDto
import retrofit2.Response
import retrofit2.http.*

interface QuantumSwapApi {

    @GET("users")
    suspend fun getLista():List<LoginResponseDto>

    @POST("users/login")
    suspend fun PostUsersLoginAPI(@Body loginResponseDto: LoginResponseDto): Response<LoginResponseDto>

    @PUT("users")
    suspend fun PutUsersAPI(@Body loginResponseDto: LoginResponseDto): Response<LoginResponseDto>

    @GET("products")
    suspend fun getListaProductos():List<ProductosDto>

    @PUT("products")
    suspend fun PutProductsApi(@Body productosDto: ProductosDto): Response<ProductosDto>

    @DELETE("products/{Id}")
    suspend fun DeleteProductsAPI(@Path("Id") Id: Int): Response<List<ProductosDto>>
}