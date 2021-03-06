package com.rola.lukasz.myshop.offer.repository

import com.rola.lukasz.myshop.offer.model.Component
import com.rola.lukasz.myshop.offer.model.SaleOffer
import java.util.*

class DummyOffers {
    companion object {
        val OFFERS =  listOf(
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
                name = "IPhone 13",
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
            ),
            SaleOffer(
                id = UUID.randomUUID(),
                name = "Samsung Galaxy S21 Ultra",
                imageUrl = "https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2340&q=80",
                deliveryInDays = 11,
                priceInDollars = 1000,
                specification = listOf(
                    Component("Camera Resolution", "108.0 MP"),
                    Component("Operating System", "Android"),
                    Component("Model Number", "SM-G998U"),
                    Component("Ram", "12 GB")
                ),
                additionalInfo = "The Galaxy S21 Ultra is the top-of-the-line model and showcases some impressive camera hardware, which will appeal to those looking for the ultimate flexibility, no matter the cost.",
                sellerId = UUID.fromString("0ca1a570-bf10-45f8-99f4-ccf602cac483"),
            ),
            SaleOffer(
                id = UUID.randomUUID(),
                name = "Huawei Watch 3 Active",
                imageUrl = "https://images.unsplash.com/photo-1517502474097-f9b30659dadb?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=927&q=80",
                deliveryInDays = 5,
                priceInDollars = 100,
                specification = listOf(
                    Component("Operating system", "Apple Watch OS"),
                    Component("Features", "Barometer, Accelerometer"),
                    Component("Case size", "46mm"),
                    Component("Storage capacity", "16 GB")
                ),
                additionalInfo = "Devices complying with the 5 ATM-rated water have a water resistance rating of 50 meters under ISO standard 22810:2010.",
                sellerId = UUID.fromString("0ca1a570-bf10-45f8-99f4-ccf602cac483")
            )
        )
    }
}