package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.DTO.LoginDto
import edu.ucne.quantumswap.data.remote.DTO.ProductDTO
import edu.ucne.quantumswap.data.remote.QuantumSwapAPI
import edu.ucne.quantumswap.data.remote.DTO.UserDTO
import edu.ucne.quantumswap.ui.login.Loginviewmodel
import edu.ucne.quantumswap.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.http.Body
import java.io.IOException
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val API: QuantumSwapAPI
){

//    suspend fun getAllUsers() = API.getAllUsers()
    suspend fun signUser(UserDTO: UserDTO): Flow<Resource<Unit>> = flow {

        try {
            emit(Resource.Loading())

            emit(Resource.Success(API.SignUser(UserDTO)))

        } catch ( e: HttpException){

            emit(Resource.Error(e.message() ?: "General HTTP Error"))

        } catch (e: IOException) {

            emit(Resource.Error(e.message ?: "Check your internet connection"))

        }

    }

    suspend fun SignUser(response: UserDTO) = API.SignUser(response)


    suspend fun loginUserWithEmail(loginDto: LoginDto) =  API.loginUserWithEmail(loginDto)

}