package cs.roberto.shared.beer.presentation.get_beers

import androidx.lifecycle.LiveData
import cs.roberto.core.clean.Either
import cs.roberto.core.clean.Status
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersFailure
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersResponse

/** */
typealias GetBeersStatus = Status<GetBeersFailure, GetBeersResponse>

/** */
interface GetBeers {

    /** */
    fun getBeersAsLiveData(
        page: Int,
        pageSize: Int,
    ): LiveData<GetBeersStatus>

    /** */
    suspend fun getBeersAsEither(
        page: Int,
        pageSize: Int,
    ): Either<GetBeersFailure, GetBeersResponse>

}