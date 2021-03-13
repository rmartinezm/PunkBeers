package cs.roberto.punkbeers.presentation.feature.detail_view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cs.roberto.shared.beer.presentation.get_beer_details.GetBeerDetails
import cs.roberto.shared.beer.presentation.get_beer_details.GetBeerDetailsStatus

/** */
class DetailViewModel(
    private val beerId: Int,
    getBeerDetails: GetBeerDetails
) : ViewModel(),
    GetBeerDetails by getBeerDetails {

    /** */
    fun getBeerDetailsAsLiveData(): LiveData<GetBeerDetailsStatus> =
        getBeerDetailsAsLiveData(beerId)

}
