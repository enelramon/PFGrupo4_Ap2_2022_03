package edu.ucne.quantumswap.ui.Store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.remote.DTO.ProductDTO
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
    val repository: ProductsRepository
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
}