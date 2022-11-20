package edu.ucne.quantumswap.data.local.dao

import androidx.room.*
import edu.ucne.quantumswap.data.local.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertproduct(product: Product)

    @Update
    suspend fun updateproduct(product: Product)

    @Delete
    suspend fun deleteproduct(product: Product)

    @Query("SELECT * FROM Products WHERE ProductId = :Id")
    suspend fun find(Id: Int):Product

    @Query("select * from products")
    fun getList(): Flow<List<Product>>
}
