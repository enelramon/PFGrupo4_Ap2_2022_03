package edu.ucne.quantumswap.data.remote

import edu.ucne.quantumswap.data.remote.DTO.LoginDto
import edu.ucne.quantumswap.data.remote.DTO.UserDTO
import edu.ucne.quantumswap.data.remote.DTO.ProductDTO
import edu.ucne.quantumswap.data.remote.DTO.UserLoginDto
import retrofit2.Response
import retrofit2.http.*

interface QuantumSwapAPI{

    //Productos
    @GET("products")
    suspend fun getAllProducts():List<ProductDTO>

    @GET("products/{Id}")
    suspend fun GetFind(@Path("Id") Id: Int):List<ProductDTO>

    @PUT("products")
    suspend fun putProduct(@Body ProductDTO: ProductDTO): List<ProductDTO>

    @DELETE("products/{Id}")
    suspend fun deleteProduct(@Path("Id") Id: Int): List<ProductDTO>

    //Usuarios
    @GET("users")
    suspend fun getAllUsers():List<UserDTO>

    @PUT("users")
    suspend fun SignUser(@Body userDTO: UserDTO)

    @POST("users/login")
    suspend fun loginUserWithEmail(@Body loginDto: LoginDto)
}