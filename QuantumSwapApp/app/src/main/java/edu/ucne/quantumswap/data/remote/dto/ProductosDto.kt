package edu.ucne.quantumswap.data.remote.dto

data class ProductosDto (
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
