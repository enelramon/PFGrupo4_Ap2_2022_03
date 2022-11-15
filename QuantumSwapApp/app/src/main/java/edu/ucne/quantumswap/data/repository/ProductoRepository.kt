package edu.ucne.quantumswap.data.repository

import edu.ucne.quantumswap.data.remote.QuantumSwapApi
import javax.inject.Inject

class ProductoRepository @Inject constructor(
    val quantumSwapApi: QuantumSwapApi
){

    suspend fun GetLista() = quantumSwapApi.getListaProductos()

    suspend fun DeleteProducsApi(Id:Int) = quantumSwapApi.DeleteProductsAPI(Id)

}