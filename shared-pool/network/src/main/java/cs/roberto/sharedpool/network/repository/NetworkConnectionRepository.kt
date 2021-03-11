package cs.roberto.sharedpool.network.repository

import androidx.lifecycle.LiveData

/** */
interface NetworkConnectionRepository {

    /* */
    val isOnline: Boolean

    /* */
    val isOnlineLiveData: LiveData<Boolean>


    /** */
    suspend fun fetch()

}
