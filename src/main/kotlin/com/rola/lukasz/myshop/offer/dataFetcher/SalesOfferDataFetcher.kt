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
        emitter.tryEmitNext(salesOfferRepository.allOffers())
    }

    @DgsQuery
    fun offers(): List<SaleOffer> {
        return salesOfferRepository.allOffers()
    }

    @DgsQuery
    fun offer(@InputArgument id: String): SaleOffer{
        return salesOfferRepository.findSaleOfferById(UUID.fromString(id))
    }

    @DgsMutation
    fun addOffer(@InputArgument saleOffer: SaleOfferInput): SaleOffer {
        val newOffer = salesOfferRepository.addSaleOffer(saleOffer)
        emitter.tryEmitNext(salesOfferRepository.allOffers())

        return newOffer
    }

    @DgsMutation
    fun removeOffer(@InputArgument id: String): SaleOffer {
        val removedOffer = salesOfferRepository.removeSaleOffer(UUID.fromString(id))
        emitter.tryEmitNext(salesOfferRepository.allOffers())

        return removedOffer
    }

    @DgsSubscription(field = "offers")
    fun subscribeOffers(): Publisher<List<SaleOffer>> {
        return emitter.asFlux()
    }

    @DgsData(parentType = "SaleOffer", field = "seller")
    fun fetchUser(dfe: DgsDataFetchingEnvironment): User{
        val offer = dfe.getSource<SaleOffer>()

        return userRepository.findUserById(offer.sellerId)
    }
}