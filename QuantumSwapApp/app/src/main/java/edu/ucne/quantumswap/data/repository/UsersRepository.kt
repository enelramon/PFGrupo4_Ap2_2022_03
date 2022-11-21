package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.DTO.LoginDto
import edu.ucne.quantumswap.data.remote.QuantumSwapAPI
import edu.ucne.quantumswap.data.remote.DTO.UserDTO
import edu.ucne.quantumswap.ui.login.Loginviewmodel
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val API: QuantumSwapAPI
){

    suspend fun getAllUsers() = API.getAllUsers()

    suspend fun SignUser(response: UserDTO) = API.SignUser(response)

//    suspend fun loginUserWithEmail(loginDto: LoginDto) = API.loginUserWithEmail(loginDto)

    suspend fun loginUserWithEmail(loginDto: LoginDto){

        try {
            API.loginUserWithEmail(loginDto)
        } catch (e: Exception){
            throw e
        }
    }

}