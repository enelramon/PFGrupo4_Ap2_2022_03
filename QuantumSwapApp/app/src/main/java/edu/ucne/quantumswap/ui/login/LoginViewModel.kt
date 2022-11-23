package edu.ucne.quantumswap.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.remote.Dto.LoginDto
import edu.ucne.quantumswap.data.repository.UsersRepository
import edu.ucne.quantumswap.domain.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Loginviewmodel @Inject constructor(
    private val apiuser: UsersRepository
) : ViewModel(){

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun AuthUser(){
        viewModelScope.launch {

            Resource.Loading(data = null)

            try {
                val response = apiuser.loginUserWithEmail(LoginDto(Email = email, Password = password))

                Resource.Success(data = response)

            } catch (ex: Exception) {

                Resource.Error(data = null, message = ex.message ?: "Error occured!")
            }
        }
    }



}