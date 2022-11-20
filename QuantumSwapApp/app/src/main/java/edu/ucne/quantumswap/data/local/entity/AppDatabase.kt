package edu.ucne.quantumswap.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.quantumswap.data.local.dao.ProductDao

@Database(
    entities = [Product::class],
    version = 2
)
abstract class AppDataBase : RoomDatabase(){
    abstract val ProductDao: ProductDao
}