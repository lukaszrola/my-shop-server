package com.rola.lukasz.myshop.dataFetcher

import com.netflix.graphql.dgs.*
import com.rola.lukasz.myshop.model.SaleOffer
import com.rola.lukasz.myshop.model.SaleOfferInput
import com.rola.lukasz.myshop.repository.SalesOfferRepository
import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks

@DgsComponent
class SalesOfferDataFetcher(private val salesOfferRepository: SalesOfferRepository) {
    private val emitter = Sinks.many().replay().latest<List<SaleOffer>>()

    init {
        emitter.tryEmitNext(salesOfferRepository.allSaleOffers())
    }

    @DgsQuery
    fun findSaleOffers(): List<SaleOffer> {
        return salesOfferRepository.allSaleOffers()
    }

    @DgsMutation
    fun addSaleOffer(@InputArgument saleOffer: SaleOfferInput): SaleOffer {
        val newOffer = salesOfferRepository.addSaleOffer(saleOffer)
        emitter.tryEmitNext(salesOfferRepository.allSaleOffers())

        return newOffer
    }

    @DgsSubscription
    fun subscribeNewOffers(): Publisher<List<SaleOffer>> {
        return emitter.asFlux()
    }
}