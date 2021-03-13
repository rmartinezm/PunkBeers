package cs.roberto.punkbeers.presentation.feature.master_view.adapter

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import cs.roberto.shared.beer.domain.entity.Beer

/** */
class BeerDataSourceFactory : DataSource.Factory<Int, Beer>() {

    /* */
    val sourceLiveData = MutableLiveData<BeerPageDataSource>()

    /** */
    override fun create(): DataSource<Int, Beer> {
        val source = BeerPageDataSource()
        sourceLiveData.postValue(source)
        return source
    }

}