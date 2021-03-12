package cs.roberto.shared.beer.presentation.get_beers

import androidx.lifecycle.LiveData
import cs.roberto.core.clean.Status
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersFailure
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersResponse

/** */
typealias GetBeersStatus = Status<GetBeersFailure, GetBeersResponse>

/** */
interface GetBeers {

    /** */
    fun getBeersAsLiveData(page: Int): LiveData<GetBeersStatus>

}