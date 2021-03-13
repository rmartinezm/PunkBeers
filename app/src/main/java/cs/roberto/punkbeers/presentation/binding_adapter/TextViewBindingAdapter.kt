package cs.roberto.punkbeers.presentation.binding_adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

/** */
@BindingAdapter("setListAsJoinString")
fun setListAsJoinString(textView: TextView, list: List<String>?) {
    list?.let {
        textView.text = list.joinToString()
    }
}
