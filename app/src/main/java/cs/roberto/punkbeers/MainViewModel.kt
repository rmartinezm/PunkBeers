package cs.roberto.punkbeers

import androidx.lifecycle.ViewModel
import cs.roberto.shared.beer.presentation.get_beer_details.GetBeerDetails
import cs.roberto.shared.beer.presentation.get_beers.GetBeers

/** */
class MainViewModel(
    getBeers: GetBeers
) : ViewModel(),
    GetBeers by getBeers
