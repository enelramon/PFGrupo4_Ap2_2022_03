package edu.ucne.quantumswap.data.local.entity
import androidx.room.Entity
import  androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val ProductId:Int,
    val Description:String,
    val Price:Int,
    val Image:String,
)
