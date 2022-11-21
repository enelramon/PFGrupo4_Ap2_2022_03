package edu.ucne.quantumswap.ui.Store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.local.entity.Product
import edu.ucne.quantumswap.data.remote.DTO.ProductDTO
import edu.ucne.quantumswap.data.repository.ProductEntityRepository
import edu.ucne.quantumswap.data.repository.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProductsUiState(
    val products: List<ProductDTO> = emptyList()
)

@HiltViewModel
class StoreViewModel @Inject constructor(
    val repository: ProductsRepository,
    val repositoryroom: ProductEntityRepository
): ViewModel(){

    var uiState = MutableStateFlow(ProductsUiState())
        private set

    init{
        viewModelScope.launch {
            uiState.update {
                it.copy(
                    repository.getAllProducts()
                )
            }
        }
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