package com.rola.lukasz.myshop.offer.dataFetcher

import com.netflix.graphql.dgs.*
import com.rola.lukasz.myshop.offer.model.SaleOffer
import com.rola.lukasz.myshop.offer.model.SaleOfferInput
import com.rola.lukasz.myshop.offer.repository.SalesOfferRepository
import com.rola.lukasz.myshop.user.model.User
import com.rola.lukasz.myshop.user.repository.UserRepository
import org.reactivestreams.Publisher
import reactor.core.publisher.Sinks
import java.util.*

@DgsComponent
class SalesOfferDataFetcher(private val salesOfferRepository: SalesOfferRepository, private val userRepository: UserRepository) {
    private val emitter = Sinks.many().replay().latest<List<SaleOffer>>()

    init {
        emitter.tryEmitNext(salesOfferRepository.allSaleOffers())
    }

    @DgsQuery
    fun findSaleOffers(): List<SaleOffer> {
        return salesOfferRepository.allSaleOffers()
    }

    @DgsQuery
    fun findOfferById(@InputArgument id: String): SaleOffer{
        return salesOfferRepository.findSaleOfferById(UUID.fromString(id))
    }

    @DgsData(parentType = "SaleOffer", field = "seller")
    fun fetchUser(dfe: DgsDataFetchingEnvironment): User{
        val offer = dfe.getSource<SaleOffer>()

        return userRepository.findUserById(offer.sellerId)
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