package com.rola.lukasz.myshop.offer.repository

import com.rola.lukasz.myshop.offer.model.Component
import com.rola.lukasz.myshop.offer.model.SaleOffer
import com.rola.lukasz.myshop.offer.model.SaleOfferInput
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
            priceInDollars = 3500,
            specification = listOf(
                Component("Processor", "Intel Core i7-11700K"),
                Component("Memory", "16 GB"),
                Component("Graphic Card", "AMD Radeon Pro 5500M"),
                Component("Disk", "500 GB, SSD")
            ),
            additionalInfo = "Incredibly light and boasting a speedy performance, get your work done anywhere with the MacBook Air (2020).",
            sellerId = UUID.fromString("f8035e24-a14b-4557-a25e-0bdbec85eb1f")
        ),
        SaleOffer(
            id = UUID.randomUUID(),
            name = "IPhone 10",
            imageUrl = "https://images.unsplash.com/photo-1554933827-294c19989ff4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80",
            deliveryInDays = 2,
            priceInDollars = 2000,
            specification = listOf(
                Component("Chipset Model", "Apple A15 Bionic"),
                Component("Network", "Unlocked"),
                Component("Operating System", "IOS"),
                Component("Storage Capacity", "128 GB")
            ),
            additionalInfo = "iPhone 13 Pro Max. The biggest Pro camera system upgrade ever. Super Retina XDR display with ProMotion for a faster, more responsive feel. Lightning-fast A15 Bionic chip. Superfast 5G",
            sellerId = UUID.fromString("0ca1a570-bf10-45f8-99f4-ccf602cac483")
        )
    )

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