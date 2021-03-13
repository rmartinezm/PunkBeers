package cs.roberto.punkbeers.presentation.feature.master_view.adapter

import androidx.paging.PageKeyedDataSource
import cs.roberto.core.clean.onLeft
import cs.roberto.core.clean.onRight
import cs.roberto.shared.beer.domain.entity.Beer
import cs.roberto.shared.beer.presentation.get_beers.GetBeers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

/** */
class BeerPageDataSource : PageKeyedDataSource<Int, Beer>() {

    /* */
    private val getBeers: GetBeers by inject(GetBeers::class.java)

    /** */
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Beer>
    ) {
        val previousPageKey: Int? = null
        CoroutineScope(Dispatchers.IO).launch {
            getBeers.getBeersAsEither(1, params.requestedLoadSize)
                .onLeft { callback.onResult(mutableListOf(), previousPageKey, null) }
                .onRight { callback.onResult(it.beers, previousPageKey, 2) }
        }
    }

    /** */
    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Beer>
    ) {
        /* NOT IMPLEMENTATION REQUIRED */
    }

    /** */
    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Beer>
    ) {
        val page: Int = params.key
        CoroutineScope(Dispatchers.IO).launch {
            getBeers.getBeersAsEither(page, params.requestedLoadSize)
                .onLeft { callback.onResult(mutableListOf(), null) }
                .onRight { callback.onResult(it.beers, page.inc()) }
        }
    }

}