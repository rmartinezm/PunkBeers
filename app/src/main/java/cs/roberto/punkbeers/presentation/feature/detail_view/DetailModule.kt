package cs.roberto.punkbeers.presentation.feature.detail_view

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/* */
val detailModule: Module = module {

    /* */
    viewModel { (beerId: Int) ->
        DetailViewModel(
            beerId = beerId,
            getBeerDetails = get(),
        )
    }

}