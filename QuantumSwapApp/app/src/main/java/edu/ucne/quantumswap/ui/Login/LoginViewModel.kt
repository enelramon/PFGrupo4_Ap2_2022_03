package edu.ucne.quantumswap.ui.login

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.remote.DTO.LoginDto
import edu.ucne.quantumswap.data.remote.DTO.UserDTO
import edu.ucne.quantumswap.data.repository.UsersRepository
import edu.ucne.quantumswap.ui.Store.ProductsUiState
import edu.ucne.quantumswap.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginUiSate(
    val isLoading: Boolean = false,
    val Exit: Boolean = false,
    var error: String = ""
)

@HiltViewModel
class Loginviewmodel @Inject constructor(
    private val apiuser: UsersRepository
) : ViewModel(){

    private var _state = mutableStateOf(LoginUiSate())
    val state: State<LoginUiSate> = _state

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun AuthUser(){
        viewModelScope.launch {
            apiuser.loginUserWithEmail(UserDTO(
                UserId = 0,
                Name = "",
                LastName = "",
                Email = email,
                Password = password,
                SecretKey = "",
                CreationDate = "",
                ModificationDate = "",
                Status = 0
            ))
        }
    }



}