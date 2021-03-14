package cs.roberto.shared.beer.data

import cs.roberto.core.clean.Either
import cs.roberto.core.clean.flatMapSuspend
import cs.roberto.core.clean.onLeft
import cs.roberto.core.clean.onRight
import cs.roberto.shared.beer.data.data_source.local.BeerDataSourceLocal
import cs.roberto.shared.beer.data.data_source.remote.BeerDataSourceRemote
import cs.roberto.shared.beer.domain.BeerRepository
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsFailure
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsResponse
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersFailure
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersResponse
import cs.roberto.sharedpool.network.repository.NetworkConnectionRepository

/** */
internal class BeerRepositoryImpl(
    private val beerDataSourceLocal: BeerDataSourceLocal,
    private val beerDataSourceRemote: BeerDataSourceRemote,
    networkConnectionRepository: NetworkConnectionRepository,
) : BeerRepository,
    NetworkConnectionRepository by networkConnectionRepository {

    /** */
    override suspend fun getBeers(
        page: Int,
        pageSize: Int
    ): Either<GetBeersFailure, GetBeersResponse> {
        if (isOnline) {
            val remoteResponse = beerDataSourceRemote.getBeers(page, pageSize)
                .onRight { beerDataSourceLocal.saveBeers(it.beers) }
            if (remoteResponse.isRight)
                if (remoteResponse.rightValue().beers.isEmpty())
                    return remoteResponse
        }
        return beerDataSourceLocal.getBeers(page, pageSize)
    }

    /** */
    override suspend fun getBeerDetails(
        beerId: Int
    ): Either<GetBeerDetailsFailure, GetBeerDetailsResponse> {
        if (isOnline) {
            beerDataSourceRemote.getBeerDetails(beerId)
                .onRight { beerDataSourceLocal.saveBeerDetails(it.beerDetails) }
        }
        return beerDataSourceLocal.getBeerDetails(beerId)
    }

}
