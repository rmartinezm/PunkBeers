package cs.roberto.punkbeers.presentation.feature.master_view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cs.roberto.punkbeers.databinding.ViewHolderBeerBinding
import cs.roberto.shared.beer.domain.entity.Beer

/** */
class BeerViewHolder(
    private val binding: ViewHolderBeerBinding
) : RecyclerView.ViewHolder(binding.root) {

    /* */
    private lateinit var beer: Beer

    /** */
    fun bind(beer: Beer) {
        this.beer = beer
        binding.beer = beer
    }

    /** */
    fun setOnBeerActionClickListener(action: (Beer) -> Unit) {
        binding.root.setOnClickListener { action(beer) }
    }

    /** */
    companion object {

        /** */
        fun from(parent: ViewGroup): BeerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ViewHolderBeerBinding.inflate(layoutInflater, parent, false)
            return BeerViewHolder(binding)
        }

    }

}