package edu.ucne.quantumswap.ui.Store

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.local.entity.Product
import edu.ucne.quantumswap.data.remote.DTO.ProductDTO
import edu.ucne.quantumswap.data.repository.ProductEntityRepository
import edu.ucne.quantumswap.data.repository.ProductsRepository
import edu.ucne.quantumswap.utils.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProductsUiState(
    val isLoading: Boolean = false,
    val products: List<ProductDTO> = emptyList(),
    val error: String = ""
)

@HiltViewModel
class StoreViewModel @Inject constructor(
    val repository: ProductsRepository,
    val repositoryroom: ProductEntityRepository
): ViewModel(){

//    var uiState = MutableStateFlow(ProductsUiState())
//        private set

    private var _state = mutableStateOf(ProductsUiState())
    val state: State<ProductsUiState> = _state



    init{
            repository.getAllProducts().onEach {
                    result ->

                when(result) {
                    is Resource.Loading -> {
                        _state.value = ProductsUiState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _state.value = ProductsUiState(products = result.data ?: emptyList())
                    }

                    is Resource.Error -> {
                        _state.value = ProductsUiState(error = result.message ?: "unknown error")
                    }
                }
            }.launchIn(viewModelScope)
    }

    fun AddShoppingCart(productId: Int, descripcion: String, price: Int, image: String){
        viewModelScope.launch {
            repositoryroom.InsertProduct(
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


