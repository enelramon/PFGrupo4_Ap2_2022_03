package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.Dto.ShoppingCartDto
import edu.ucne.quantumswap.data.remote.QuantumSwapApi
import edu.ucne.quantumswap.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ShoppingRepository @Inject constructor(
    private val Api: QuantumSwapApi
){

    suspend fun SaveShopping(shoppingCartDto: ShoppingCartDto): Flow<Resource<Unit>> = flow {

        try {
            emit(Resource.Loading())

            emit(Resource.Success(Api.SaveShopping(shoppingCartDto)))

        } catch ( e: HttpException){

            emit(Resource.Error(e.message() ?: "General HTTP Error"))

        } catch (e: IOException) {

            emit(Resource.Error(e.message ?: "Check your internet connection"))

        }

    }
}