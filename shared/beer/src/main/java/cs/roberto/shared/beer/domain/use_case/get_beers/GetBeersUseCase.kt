package cs.roberto.shared.beer.domain.use_case.get_beers

import cs.roberto.core.clean.Either
import cs.roberto.core.clean.UseCase
import cs.roberto.shared.beer.domain.BeerRepository

/** */
class GetBeersUseCase(
    private val beerRepository: BeerRepository
) : UseCase<GetBeersResponse, GetBeersParams, GetBeersFailure>() {

    /** */
    override suspend fun run(params: GetBeersParams): Either<GetBeersFailure, GetBeersResponse> =
        beerRepository.getBeers(params.page, params.pageSize)
}