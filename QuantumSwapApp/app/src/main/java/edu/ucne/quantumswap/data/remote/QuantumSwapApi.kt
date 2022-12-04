package edu.ucne.quantumswap.data.remote

import edu.ucne.quantumswap.data.remote.Dto.LoginDto
import edu.ucne.quantumswap.data.remote.Dto.UserDto
import edu.ucne.quantumswap.data.remote.Dto.ProductDto
import edu.ucne.quantumswap.data.remote.Dto.ShoppingCartDto
import retrofit2.http.*

interface QuantumSwapApi{

    //Productos
    @GET("products")
    suspend fun getAllProducts():List<ProductDto>

    @GET("products/{Id}")
    suspend fun GetFind(@Path("Id") Id: Int):List<ProductDto>

    @PUT("products")
    suspend fun putProduct(@Body ProductDTO: ProductDto): List<ProductDto>

    @DELETE("products/{Id}")
    suspend fun deleteProduct(@Path("Id") Id: Int): List<ProductDto>

    //Usuarios
    @GET("users")
    suspend fun getAllUsers():List<UserDto>

    @PUT("users")
    suspend fun SignUser(@Body userDTO: UserDto)

    @POST("users/login")
    suspend fun loginUserWithEmail(@Body loginDto: LoginDto)

    //ShoppingCart
    @PUT("shoppingcarts")
    suspend fun SaveShopping(@Body shoppingCartDto: ShoppingCartDto)

}