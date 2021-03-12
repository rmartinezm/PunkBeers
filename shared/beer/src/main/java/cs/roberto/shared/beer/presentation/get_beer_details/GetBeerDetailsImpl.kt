package cs.roberto.shared.beer.presentation.get_beer_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import cs.roberto.core.clean.Status
import cs.roberto.core.clean.onLeft
import cs.roberto.core.clean.onRight
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsParams
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

/** */
internal class GetBeerDetailsImpl(
    private val getBeerDetailsUseCase: GetBeerDetailsUseCase
) : GetBeerDetails {

    /** */
    override fun getBeerDetailsAsLiveData(beerId: Int): LiveData<GetBeerDetailsStatus> =
        flow<GetBeerDetailsStatus> {
            emit(Status.Loading())
            val params = GetBeerDetailsParams(beerId)
            getBeerDetailsUseCase.run(params)
                .onLeft { emit(Status.Failed(it)) }
                .onRight { emit(Status.Done(it)) }
        }.asLiveData(Dispatchers.IO)

}