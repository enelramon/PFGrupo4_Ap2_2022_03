package edu.ucne.quantumswap.data.local.entity
import androidx.room.Entity
import  androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val ProductId:Int,
    val CategoryId:Int,
    val SectionId:Int,
    val CategoryDescription:String,
    val SectionDescription:String,
    val Description:String,
    val Stock:Int,
    val Cost:Int,
    val Price:Int,
    val Discount:Int,
    val Image:String,
)
