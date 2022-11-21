package edu.ucne.quantumswap.data.repository

import androidx.room.Delete
import edu.ucne.quantumswap.data.local.entity.AppDataBase
import edu.ucne.quantumswap.data.local.entity.Product
import javax.inject.Inject

class ProductEntityRepository @Inject constructor(
    val db: AppDataBase
) {
    suspend fun InsertProduct(product: Product){
        db.ProductDao.insertproduct(product)
    }

    fun GetList() = db.ProductDao.getList()

    suspend fun Delete(product: Product) = db.ProductDao.deleteproduct(product)
}