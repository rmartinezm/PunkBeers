package cs.roberto.shared.beer.data.data_source.local

import android.util.Log
import cs.roberto.core.clean.Either
import cs.roberto.shared.beer.data.BeerDataSource
import cs.roberto.shared.beer.domain.entity.BeerDetails
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsFailure
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsResponse

/** */
internal class BeerDataSourceLocal : BeerDataSource {

    /** */
    override suspend fun getBeerDetails(
        beerId: Int
    ): Either<GetBeerDetailsFailure, GetBeerDetailsResponse> {
        TODO("Not yet implemented")
    }

    /** */
    suspend fun saveBeerDetails(beerDetails: BeerDetails) {
        Log.e("BeerDataSourceLocal", beerDetails.toString())
    }

}