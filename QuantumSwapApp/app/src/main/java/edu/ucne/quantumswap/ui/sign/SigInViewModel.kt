package edu.ucne.quantumswap.ui.sign

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.remote.DTO.LoginDto
import edu.ucne.quantumswap.data.remote.DTO.UserDTO
import edu.ucne.quantumswap.data.repository.UsersRepository
import edu.ucne.quantumswap.domain.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SigInViewModel @Inject constructor(
    private val apiSign: UsersRepository
): ViewModel() {

    var name by mutableStateOf("")
    var lastname by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun SignInUser() {
        viewModelScope.launch {

            Resource.Loading(data = null)

            try {
                val data = apiSign.signUser(
                    UserDTO(
                        UserId = 0,
                        Name = name,
                        LastName = lastname,
                        Email = email,
                        Password = password,
                        SecretKey = "",
                        CreationDate = "",
                        ModificationDate = "",
                        Status = 0
                    )
                )

                Resource.Success(data = data)

            } catch (ex: Exception) {

                Resource.Error(data = null, message = ex.message ?: "Error occured!")

            }
        }
    }

}

