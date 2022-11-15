package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.QuantumSwapApi
import edu.ucne.quantumswap.data.remote.dto.LoginResponseDto
import javax.inject.Inject

class LoginRepository @Inject constructor(
    val quantumSwapApi: QuantumSwapApi
){

    suspend fun GetLista() = quantumSwapApi.getLista()

    suspend fun PutUsersApi(response: LoginResponseDto) = quantumSwapApi.PutUsersAPI(response)

    suspend fun PostLoginApi(response: LoginResponseDto) = quantumSwapApi.PutUsersAPI(response)
}