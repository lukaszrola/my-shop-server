package com.rola.lukasz.myshop.offer.model

import java.util.*

class SaleOffer(val id: UUID, val name: String, val imageUrl: String, val deliveryInDays: Int, val priceInDollars: Int, val specification: List<Component>, val sellerId: UUID)