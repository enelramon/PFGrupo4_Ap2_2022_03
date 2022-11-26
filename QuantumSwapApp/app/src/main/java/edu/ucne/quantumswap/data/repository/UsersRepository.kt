package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.DTO.LoginDto
import edu.ucne.quantumswap.data.remote.QuantumSwapAPI
import edu.ucne.quantumswap.data.remote.DTO.UserDTO
import edu.ucne.quantumswap.ui.login.Loginviewmodel
import edu.ucne.quantumswap.utils.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val API: QuantumSwapAPI
){

    fun getAllUsers(): Flow<Resource<List<UserDTO>>> = flow {

        try {

            emit(Resource.Loading())

            val Alluser = API.getAllUsers()

            emit(Resource.Success(Alluser))

        } catch ( e: HttpException){

            emit(Resource.Error(e.message() ?: "General HTTP Error"))

        } catch (e: IOException) {

            emit(Resource.Error(e.message ?: "Check your internet connection"))
        }
    }

    fun loginUserWithEmail(userDTO: UserDTO): Flow<Resource<List<UserDTO>>> = flow {

        try {

            emit(Resource.Loading())

            val Alluser = API.loginUserWithEmail(userDTO)

            emit(Resource.Success(Alluser))

        } catch ( e: HttpException){

            emit(Resource.Error(e.message() ?: "General HTTP Error"))

        } catch (e: IOException) {

            emit(Resource.Error(e.message ?: "Check your internet connection"))
        }
    }

    suspend fun SignUser(response: UserDTO) = API.SignUser(response)

//    suspend fun loginUserWithEmail(userDTO: UserDTO) =  API.loginUserWithEmail(userDTO)

}