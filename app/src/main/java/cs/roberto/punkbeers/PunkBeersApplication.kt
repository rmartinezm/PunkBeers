package cs.roberto.punkbeers

import android.app.Application
import cs.roberto.punkbeers.di.initKoin
import cs.roberto.sharedpool.network.initConnectivityReceiverBroadcastReceiver

/** */
class PunkBeersApplication : Application() {

    /** */
    override fun onCreate() {
        super.onCreate()
        initKoin()
        initConnectivityReceiverBroadcastReceiver()
    }

}