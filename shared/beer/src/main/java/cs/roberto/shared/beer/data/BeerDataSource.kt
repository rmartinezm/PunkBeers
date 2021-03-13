package cs.roberto.shared.beer.data

import cs.roberto.core.clean.Either
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsFailure
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsResponse
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersFailure
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersResponse

/** */
internal interface BeerDataSource {

    /** */
    suspend fun getBeers(
        page: Int,
        pageSize: Int
    ): Either<GetBeersFailure, GetBeersResponse>

    /** */
    suspend fun getBeerDetails(
        beerId: Int
    ): Either<GetBeerDetailsFailure, GetBeerDetailsResponse>

}