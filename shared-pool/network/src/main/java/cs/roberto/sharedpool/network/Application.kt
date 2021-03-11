package cs.roberto.sharedpool.network

import android.app.Application
import android.content.IntentFilter
import cs.roberto.sharedpool.network.broadcast_receiver.ConnectivityReceiver

/** */
fun Application.initConnectivityReceiverBroadcastReceiver(){
    registerReceiver(
        ConnectivityReceiver(),
        IntentFilter(ConnectivityReceiver.CONNECTIVITY_CHANGE)
    )
}
