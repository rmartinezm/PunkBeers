package cs.roberto.shared.beer.domain.use_case.get_beer_details

import cs.roberto.core.clean.Either
import cs.roberto.core.clean.UseCase
import cs.roberto.shared.beer.domain.BeerRepository

/** */
class GetBeerDetailsUseCase(
    private val beerRepository: BeerRepository
) : UseCase<GetBeerDetailsResponse, GetBeerDetailsParams, GetBeerDetailsFailure>() {

    /** */
    override suspend fun run(
        params: GetBeerDetailsParams
    ): Either<GetBeerDetailsFailure, GetBeerDetailsResponse> =
        beerRepository.getBeerDetails(params.beerId)

}