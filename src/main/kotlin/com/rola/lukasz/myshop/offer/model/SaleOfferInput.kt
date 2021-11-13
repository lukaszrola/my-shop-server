package com.rola.lukasz.myshop.offer.model

class SaleOfferInput(
    val name: String,
    val imageUrl: String,
    val deliveryInDays: Int,
    val priceInDollars: Int,
    val specification: List<ComponentInput>,
    val additionalInfo: String,
    val sellerId: String
)