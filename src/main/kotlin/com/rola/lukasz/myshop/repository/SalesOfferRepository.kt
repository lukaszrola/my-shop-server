package com.rola.lukasz.myshop.repository

import com.rola.lukasz.myshop.model.SaleOffer
import com.rola.lukasz.myshop.model.SaleOfferInput
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class SalesOfferRepository {
    private val offers = mutableListOf(
        SaleOffer(
            id = UUID.randomUUID(),
            name = "MacBook Pro 2019",
            imageUrl = "https://images.unsplash.com/photo-1569770218135-bea267ed7e84?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=880&q=80",
            deliveryInDays = 3,
            priceInDollars = 3500
        ),
        SaleOffer(
            id = UUID.randomUUID(),
            name = "IPhone 10",
            imageUrl = "https://images.unsplash.com/photo-1554933827-294c19989ff4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80",
            deliveryInDays = 2,
            priceInDollars = 2000
        )
    )

    fun addSaleOffer(saleOfferInput: SaleOfferInput): SaleOffer {
        val newOffer = SaleOffer(
            id = UUID.randomUUID(),
            name = saleOfferInput.name,
            imageUrl = saleOfferInput.imageUrl,
            deliveryInDays = saleOfferInput.deliveryInDays,
            priceInDollars = saleOfferInput.priceInDollars
        )

        offers.add(
            newOffer
        )

        return newOffer
    }

    fun allSaleOffers(): List<SaleOffer> = offers.toList()

}