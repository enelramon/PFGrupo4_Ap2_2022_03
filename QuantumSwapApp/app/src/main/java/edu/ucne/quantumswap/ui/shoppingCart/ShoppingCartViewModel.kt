package edu.ucne.quantumswap.ui.shoppingCart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.quantumswap.data.local.entity.Product
import edu.ucne.quantumswap.data.remote.Dto.ShoppingCartDto
import edu.ucne.quantumswap.data.repository.ProductEntityRepository
import edu.ucne.quantumswap.data.repository.ShoppingRepository
import edu.ucne.quantumswap.domain.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ShoppingCartUIState(
    val product: List<Product> = emptyList()
)


@HiltViewModel
class ShoppingCartViewModel @Inject constructor(
     private val respository: ProductEntityRepository,
     private val shoppingRepository: ShoppingRepository
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

    fun SaveShopping(){
        viewModelScope.launch {
            shoppingRepository.SaveShopping(
                ShoppingCartDto(
                    ShoppingCartId = 0,
                    UserId = 1,
                    UserName = " ",
                    Amount = 0,
                    TotalProducts = 0
                )
            )
        }

    }

    fun Delete(product: Product){
        viewModelScope.launch{
            respository.Delete(product)
        }
    }


    fun AggCant(
        id: Int,
        descripcion: String,
        price: Int,
        image: String,
        cant: Int,
        payment: Int
    ){
        viewModelScope.launch {
            respository.UpdateProduct(
                Product(
                    id,
                    descripcion,
                    price,
                    image,
                    cant,
                    payment + price
                )
            )
        }
    }

    fun ElimCant(
        id: Int,
        descripcion: String,
        price: Int,
        image: String,
        cant: Int,
        payment: Int
    ){
        viewModelScope.launch {
            respository.UpdateProduct(
                Product(
                    id,
                    descripcion,
                    price,
                    image,
                    cant,
                    payment - price
                )
            )
        }
        if (payment == 0 || payment < 0){
            EliminarProducto(id, descripcion, price, image, cant, payment)
        }
    }

    fun EliminarProducto(
        id: Int,
        descripcion: String,
        price: Int,
        image: String,
        cant: Int,
        payment: Int
    ){
        viewModelScope.launch {
            respository.Delete(
                Product(
                    id,
                    descripcion,
                    price,
                    image,
                    cant,
                    payment - price
                )
            )

        }
    }

}














//fun SaveShopping(){
//    viewModelScope.launch {
//        Resource.Loading(data = null)
//
//        try {
//            val shopping = shoppingRepository.Shopping(
//                ShoppingCartDto(
//                    ShoppingCartId = 0,
//                    UserId = 0,
//                    UserName = "",
//                    TotalProducts = 0,
//                    Amount = 0
//                )
//            )
//
//            Resource.Success(data = shopping)
//        } catch (ex: Exception) {
//            Resource.Error(data = null, message = ex.message ?: "Error occured!")
//        }
//    }
//}