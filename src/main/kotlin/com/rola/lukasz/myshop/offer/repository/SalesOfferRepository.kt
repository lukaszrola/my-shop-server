package com.rola.lukasz.myshop.offer.repository

import com.rola.lukasz.myshop.offer.model.Component
import com.rola.lukasz.myshop.offer.model.SaleOffer
import com.rola.lukasz.myshop.offer.model.SaleOfferInput
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class SalesOfferRepository {
    private val offers: MutableList<SaleOffer> = mutableListOf()

    init {
        offers += DummyOffers.OFFERS
    }

    fun addSaleOffer(saleOfferInput: SaleOfferInput): SaleOffer {
        val newOffer = SaleOffer(
            id = UUID.randomUUID(),
            name = saleOfferInput.name,
            imageUrl = saleOfferInput.imageUrl,
            deliveryInDays = saleOfferInput.deliveryInDays,
            priceInDollars = saleOfferInput.priceInDollars,
            specification = saleOfferInput.specification.map { it.toComponent() },
            additionalInfo = saleOfferInput.additionalInfo,
            sellerId = UUID.fromString(saleOfferInput.sellerId)
        )

        offers.add(
            newOffer
        )

        return newOffer
    }

    fun removeSaleOffer(id: UUID): SaleOffer {
        val offer = findSaleOfferById(id)
        offers.remove(offer)

        return offer
    }

    fun allOffers(): List<SaleOffer> = offers.toList()

    fun findSaleOfferById(id: UUID): SaleOffer {
        return offers.firstOrNull { it.id == id } ?: throw SalesOfferRepositoryException("Offer with if $id not found")
    }
}

class SalesOfferRepositoryException(message: String?) : Exception(message)