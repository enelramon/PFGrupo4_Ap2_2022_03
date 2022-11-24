package edu.ucne.quantumswap.ui.store

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.local.entity.Product
import edu.ucne.quantumswap.data.remote.Dto.ProductDto
import edu.ucne.quantumswap.data.repository.ProductEntityRepository
import edu.ucne.quantumswap.data.repository.ProductsRepository
import edu.ucne.quantumswap.domain.Resource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProductsUiState(
    val isLoading: Boolean = false,
    val products: List<ProductDto> = emptyList(),
    val error: String = ""
)

@HiltViewModel
class StoreViewModel @Inject constructor(
    val api: ProductsRepository,
    val room: ProductEntityRepository
): ViewModel(){

//    var uiState = MutableStateFlow(ProductsUiState())
//        private set

    private var _state = MutableStateFlow(ProductsUiState())
    val state: StateFlow<ProductsUiState> = _state.asStateFlow()



    init{
            api.getAllProducts().onEach { result ->
                when(result) {
                    is Resource.Loading -> {
                        //_state.value = ProductsUiState(isLoading = true)
                        _state.update { it.copy(isLoading = true) }
                    }

                    is Resource.Success -> {
//                        _state.value = ProductsUiState(products = result.data ?: emptyList())
                        _state.update {
                            it.copy(isLoading=false, products = result.data ?: emptyList())
                        }
                    }

                    is Resource.Error -> {
//                        _state.value = ProductsUiState(error = result.message ?: "unknown error")
                        _state.update {
                            it.copy(isLoading=false, error = result.message ?: "unknown error")
                        }
                    }
                }
            }.launchIn(viewModelScope)
    }

    fun AddShoppingCart(productId: Int, descripcion: String, price: Int, image: String){
        viewModelScope.launch {
            room.InsertProduct(
                Product(
                    ProductId = productId,
                    Description = descripcion,
                    Price = price,
                    Image = image
                )
            )
        }
    }
}


