package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.DTO.ProductDTO
import edu.ucne.quantumswap.data.remote.QuantumSwapAPI
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val API: QuantumSwapAPI
){

    suspend fun getAllProducts() = API.getAllProducts()

    suspend fun GetFind(Id: Int) = API.GetFind(Id)

    suspend fun putProduct(response: ProductDTO) = API.putProduct(response)

    suspend fun deleteProduct(Id:Int) = API.deleteProduct(Id)

}