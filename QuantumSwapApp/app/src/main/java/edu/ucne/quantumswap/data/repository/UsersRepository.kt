package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.Dto.LoginDto
import edu.ucne.quantumswap.data.remote.QuantumSwapApi
import edu.ucne.quantumswap.data.remote.Dto.UserDto
import edu.ucne.quantumswap.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val API: QuantumSwapApi
){

//    suspend fun getAllUsers() = API.getAllUsers()
    suspend fun signUser(UserDTO: UserDto): Flow<Resource<Unit>> = flow {

        try {
            emit(Resource.Loading())

            emit(Resource.Success(API.SignUser(UserDTO)))

        } catch ( e: HttpException){

            emit(Resource.Error(e.message() ?: "General HTTP Error"))

        } catch (e: IOException) {

            emit(Resource.Error(e.message ?: "Check your internet connection"))

        }

    }

//    suspend fun SignUser(response: UserDto) = API.SignUser(response)


    suspend fun loginUserWithEmail(loginDto: LoginDto) =  API.loginUserWithEmail(loginDto)

}