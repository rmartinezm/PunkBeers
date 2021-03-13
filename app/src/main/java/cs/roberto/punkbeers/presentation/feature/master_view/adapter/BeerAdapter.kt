package cs.roberto.punkbeers.presentation.feature.master_view.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import cs.roberto.shared.beer.domain.entity.Beer

/** */
class BeerAdapter(
    private val onBearActionClickListener: (Beer) -> Unit,
) : PagedListAdapter<Beer, BeerViewHolder>(BeerDiffCallback) {

    /** */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder =
        BeerViewHolder.from(parent)

    /** */
    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val beer: Beer? = getItem(position)
        beer?.let {
            holder.apply {
                bind(it)
                setOnBeerActionClickListener(onBearActionClickListener)
            }
        }
    }

    /** */
    private object BeerDiffCallback : DiffUtil.ItemCallback<Beer>() {

        /** */
        override fun areItemsTheSame(
            oldItem: Beer,
            newItem: Beer
        ): Boolean = oldItem.id == newItem.id

        /** */
        override fun areContentsTheSame(
            oldItem: Beer,
            newItem: Beer
        ): Boolean = oldItem.equals(newItem)

    }

}