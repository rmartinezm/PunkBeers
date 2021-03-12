package cs.roberto.shared.beer.domain.use_case.get_beer_details

import cs.roberto.core.clean.Failure

/** */
sealed class GetBeerDetailsFailure : Failure() {

    /**
     * Emitted when Internet Connection isn't available and not exists local data.
     */
    object NetworkConnectionFailure : GetBeerDetailsFailure()

    /**
     * Emitted when the action returns an business error with detail.
     */
    data class DetailFailure(
        val detail: String
    ) : GetBeerDetailsFailure()

}