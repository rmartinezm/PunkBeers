package cs.roberto.shared.beer.domain.use_case.get_beers

import cs.roberto.shared.beer.domain.entity.Beer

/** */
data class GetBeersResponse(
    val beers: List<Beer>
)
