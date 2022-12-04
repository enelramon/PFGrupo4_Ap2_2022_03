package edu.ucne.quantumswap.data.remote.Dto

data class ShoppingCartDto(
    val ShoppingCartId: Int,
    val UserId: Int,
    val UserName: String,
    val TotalProducts: Int,
    val Amount: Int,
)