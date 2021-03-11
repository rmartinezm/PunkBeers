package cs.roberto.sharedpool.network.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import cs.roberto.sharedpool.network.repository.NetworkConnectionRepository
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject

/** */
internal class ConnectivityReceiver : BroadcastReceiver() {

    /* */
    private val networkConnectionRepository by inject(NetworkConnectionRepository::class.java)

    /** */
    override fun onReceive(context: Context?, intent: Intent?) = runBlocking {
        networkConnectionRepository.fetch()
    }

    /** */
    companion object {

        /* */
        const val CONNECTIVITY_CHANGE: String = "android.net.conn.CONNECTIVITY_CHANGE"

    }

}