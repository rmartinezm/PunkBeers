package cs.roberto.punkbeers.presentation.feature.master_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cs.roberto.core.clean.Status
import cs.roberto.punkbeers.databinding.FragmentMasterViewBinding
import cs.roberto.punkbeers.presentation.feature.master_view.adapter.BeerAdapter
import cs.roberto.shared.beer.domain.entity.Beer
import org.koin.android.viewmodel.ext.android.viewModel

/** */
class MasterViewFragment : Fragment() {

    /* */
    private val binding: FragmentMasterViewBinding
            by lazy { FragmentMasterViewBinding.inflate(layoutInflater) }

    /* */
    private val masterViewViewModel: MasterViewViewModel by viewModel()

    /* */
    private lateinit var beerAdapter: BeerAdapter

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        execute()
    }

    /** */
    private fun setupViews() {
        setupBeersRecyclerView()
        setupPullToRefresh()
    }

    /** */
    private fun setupBeersRecyclerView() {
        beerAdapter = BeerAdapter(::onBeerActionClickListener)
        binding.rvBeers.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = beerAdapter
        }
    }

    /** */
    private fun setupPullToRefresh() {
        binding.srlRefresh.setOnRefreshListener {
            masterViewViewModel.invalidateDataSource()
        }

    }

    /** */
    private fun execute() {
        masterViewViewModel.getBeersPagedListAsLiveData().observe(viewLifecycleOwner) {
            beerAdapter.submitList(it)
            binding.srlRefresh.isRefreshing = false
        }
    }

    /** */
    private fun onBeerActionClickListener(beer: Beer) {
        Toast.makeText(requireContext(), beer.name, Toast.LENGTH_SHORT).show()
    }

}