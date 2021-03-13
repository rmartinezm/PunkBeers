package cs.roberto.punkbeers.presentation.feature.detail_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import cs.roberto.core.clean.Failure
import cs.roberto.core.clean.Status
import cs.roberto.punkbeers.R
import cs.roberto.punkbeers.databinding.FragmentDetailBinding
import cs.roberto.shared.beer.domain.entity.BeerDetails
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsFailure
import cs.roberto.shared.beer.presentation.get_beer_details.GetBeerDetailsStatus
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/** */
class DetailFragment : Fragment() {

    /* */
    private val binding: FragmentDetailBinding
            by lazy { FragmentDetailBinding.inflate(layoutInflater) }

    /* */
    private val args: DetailFragmentArgs by navArgs()

    /* */
    private val detailViewModel: DetailViewModel by viewModel { parametersOf(args.beerId) }

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
        setupToolbar()
    }

    /** */
    private fun setupToolbar() {
        binding.mtToolbar.setNavigationOnClickListener { onBackPressed() }
    }

    /** */
    private fun execute() {
        detailViewModel.getBeerDetailsAsLiveData()
            .observe(viewLifecycleOwner, createGetBeerDetailsStatusObserver())
    }

    /** */
    private fun createGetBeerDetailsStatusObserver() = Observer<GetBeerDetailsStatus> {
        when (it) {
            is Status.Loading -> showProgressBar()
            is Status.Failed -> manageGetBeerDetailsFailure(it.failure)
            is Status.Done -> manageGetBeerDetailsDone(it.value.beerDetails)
        }
    }

    /** */
    private fun manageGetBeerDetailsFailure(failure: GetBeerDetailsFailure) {
        hideProgressBar()
        val message: String = when (failure) {
            GetBeerDetailsFailure.NetworkConnectionFailure ->
                getString(R.string.network_connection_failure)
            is GetBeerDetailsFailure.DetailFailure -> failure.detail
        }
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    /** */
    private fun manageGetBeerDetailsDone(beerDetails: BeerDetails) {
        hideProgressBar()
        binding.beerDetails = beerDetails
    }

    /** */
    private fun showProgressBar() {
        binding.pbLoader.visibility = View.VISIBLE
    }

    /** */
    private fun hideProgressBar() {
        binding.pbLoader.visibility = View.GONE
    }

    /** */
    private fun onBackPressed() {
        findNavController().navigateUp()
    }

}