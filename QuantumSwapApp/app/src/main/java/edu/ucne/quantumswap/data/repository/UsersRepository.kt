package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.QuantumSwapAPI
import edu.ucne.quantumswap.data.remote.DTO.UserDTO
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val API: QuantumSwapAPI
){

    suspend fun getAllUsers() = API.getAllUsers()

    suspend fun saveUser(response: UserDTO) = API.saveUser(response)

    suspend fun loginUserWithEmail(response: UserDTO) = API.loginUserWithEmail(response)

}