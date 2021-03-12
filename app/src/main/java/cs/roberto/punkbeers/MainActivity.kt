package cs.roberto.punkbeers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import cs.roberto.core.clean.Status
import org.koin.android.viewmodel.ext.android.viewModel

/** */
class MainActivity : AppCompatActivity() {

    /* */
    private val mainViewModel: MainViewModel by viewModel()

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getBeerDetailsAsLiveData(1).observe(this) {
            Log.e("GET_BEER", it.toString())
            if (it is Status.Done)
                findViewById<TextView>(R.id.tv_label).text = it.value.beerDetails.toString()
        }
    }

}