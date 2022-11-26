package edu.ucne.quantumswap.ui.shoppingCart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.local.entity.Product
import edu.ucne.quantumswap.data.repository.ProductEntityRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ShoppingCartUIState(
    val product: List<Product> = emptyList()
)

@HiltViewModel
class ShoppingCartViewModel @Inject constructor(
     val respository: ProductEntityRepository
): ViewModel(){

    var uiSate = MutableStateFlow(ShoppingCartUIState())
        private set

    init {
        viewModelScope.launch {
            respository.GetList().collect {list ->
                uiSate.update {
                    it.copy(product = list)
                }

            }
        }
    }

    fun Delete(product: Product){
        viewModelScope.launch{
            respository.Delete(product)
        }
    }


}