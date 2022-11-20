package edu.ucne.quantumswap.ui.ShoppingCart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.remote.DTO.ProductDTO
import edu.ucne.quantumswap.data.repository.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ShoppingCartUIState(
    val product: List<ProductDTO> = emptyList()
)

@HiltViewModel
class ShoppingCartViewModel @Inject constructor(
     val apirespository: ProductsRepository
): ViewModel(){
    val Id by mutableStateOf("")
    var uiSate = MutableStateFlow(ShoppingCartUIState())
        private set

    init {
        viewModelScope.launch {
            uiSate.update {
                it.copy(apirespository.getAllProducts())
            }
        }
    }
}