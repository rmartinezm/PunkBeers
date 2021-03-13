package cs.roberto.punkbeers.presentation.feature.master_view

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/* */
val masterViewModule: Module = module {

    /* */
    viewModel { MasterViewViewModel() }

}