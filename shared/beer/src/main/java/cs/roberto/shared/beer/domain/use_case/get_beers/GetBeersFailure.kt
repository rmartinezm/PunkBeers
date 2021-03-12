package cs.roberto.shared.beer.domain.use_case.get_beers

import cs.roberto.core.clean.Failure

/** */
sealed class GetBeersFailure : Failure() {

    /**
     * Emitted when Internet Connection isn't available and not exists local data.
     */
    object NetworkConnectionFailure : GetBeersFailure()

    /**
     * Emitted when the action returns an business error with detail.
     */
    data class DetailFailure(
        val detail: String
    ) : GetBeersFailure()

}