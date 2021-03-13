package cs.roberto.punkbeers.presentation.feature.master_view

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import cs.roberto.punkbeers.presentation.feature.master_view.adapter.BeerDataSourceFactory
import cs.roberto.shared.beer.domain.entity.Beer
import cs.roberto.shared.beer.presentation.get_beers.GetBeers
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/** */
class MasterViewViewModel : ViewModel() {

    /* */
    private val dataSourceFactory = BeerDataSourceFactory()

    /** */
    fun getBeersPagedListAsLiveData(): LiveData<PagedList<Beer>> {
        val pageSize: Int = 20
        val pagedListConfig: PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(40)
            .setPageSize(pageSize)
            .build()
        return LivePagedListBuilder(dataSourceFactory, pagedListConfig)
            .setFetchExecutor(Executors.newFixedThreadPool(5))
            .build()
    }

    /** */
    fun invalidateDataSource() =
        dataSourceFactory.sourceLiveData.value?.invalidate()

}
