package cs.roberto.shared.beer.presentation.get_beers

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import cs.roberto.core.clean.Status
import cs.roberto.core.clean.onLeft
import cs.roberto.core.clean.onRight
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersParams
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

/** */
internal class GetBeersImpl(
    private val getBeersUseCase: GetBeersUseCase
) : GetBeers {

    /** */
    override fun getBeersAsLiveData(page: Int): LiveData<GetBeersStatus> = flow<GetBeersStatus> {
        emit(Status.Loading())
        val params = GetBeersParams(page)
        getBeersUseCase.run(params)
            .onLeft { emit(Status.Failed(it)) }
            .onRight { emit(Status.Done(it)) }
    }.asLiveData(Dispatchers.IO)

}