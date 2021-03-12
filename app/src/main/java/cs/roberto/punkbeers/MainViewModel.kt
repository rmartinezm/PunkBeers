package cs.roberto.punkbeers

import androidx.lifecycle.ViewModel
import cs.roberto.shared.beer.presentation.get_beer_details.GetBeerDetails

/** */
class MainViewModel(
    getBeerDetails: GetBeerDetails
) : ViewModel(),
    GetBeerDetails by getBeerDetails
