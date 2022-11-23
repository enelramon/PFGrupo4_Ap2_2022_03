package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.Dto.ProductDto
import edu.ucne.quantumswap.data.remote.QuantumSwapApi
import edu.ucne.quantumswap.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val api: QuantumSwapApi
){

     fun getAllProducts(): Flow<Resource<List<ProductDto>>> = flow {

         try {

            emit(Resource.Loading())

            val Allproduct = api.getAllProducts()

            emit(Resource.Success(Allproduct))

        } catch ( e: HttpException){

            emit(Resource.Error(e.message() ?: "General HTTP Error"))

        } catch (e: IOException) {

            emit(Resource.Error(e.message ?: "Check your internet connection"))

        }
    }

    suspend fun GetFind(Id: Int) = api.GetFind(Id)

//    suspend fun putProduct(response: ProductDto) = API.putProduct(response)

//    suspend fun deleteProduct(Id:Int) = API.deleteProduct(Id)

}