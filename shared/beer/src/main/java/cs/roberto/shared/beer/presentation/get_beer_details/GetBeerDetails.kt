package cs.roberto.shared.beer.presentation.get_beer_details

import androidx.lifecycle.LiveData
import cs.roberto.core.clean.Status
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsFailure
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsResponse

/** */
typealias GetBeerDetailsStatus = Status<GetBeerDetailsFailure, GetBeerDetailsResponse>

/** */
interface GetBeerDetails {

    /** */
    fun getBeerDetailsAsLiveData(beerId: Int): LiveData<GetBeerDetailsStatus>

}