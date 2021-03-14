package cs.roberto.punkbeers.presentation.feature.detail_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import cs.roberto.core.clean.Status
import cs.roberto.punkbeers.R
import cs.roberto.punkbeers.databinding.ActivityDetailBinding
import cs.roberto.shared.beer.domain.entity.BeerDetails
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsFailure
import cs.roberto.shared.beer.presentation.get_beer_details.GetBeerDetailsStatus
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/** */
class DetailActivity : AppCompatActivity() {

    /* */
    private val binding: ActivityDetailBinding
            by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    /* */
    private val args: DetailActivityArgs by navArgs()

    /* */
    private val detailViewModel: DetailViewModel by viewModel { parametersOf(args.beerId) }

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
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
            .observe(this, createGetBeerDetailsStatusObserver())
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
        val titleRes: Int
        val contentRes: Int
        when (failure) {
            is GetBeerDetailsFailure.DetailFailure -> {
                titleRes = R.string.detail_failure_title
                contentRes = R.string.detail_failure_content
            }
            GetBeerDetailsFailure.NetworkConnectionFailure -> {
                titleRes = R.string.network_connection_failure_title
                contentRes = R.string.network_connection_failure_content
            }
        }
         MaterialAlertDialogBuilder(this)
             .setTitle(titleRes)
             .setMessage(contentRes)
             .setPositiveButton(R.string.detail_failure_action) { dialog, _ ->
                 dialog.dismiss()
                 finish()
             }
             .setCancelable(false)
             .create()
             .show()
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

}