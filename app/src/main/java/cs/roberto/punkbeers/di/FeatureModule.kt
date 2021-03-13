package cs.roberto.punkbeers.di

import cs.roberto.punkbeers.presentation.feature.detail_view.detailModule
import cs.roberto.punkbeers.presentation.feature.master_view.masterViewModule
import org.koin.core.module.Module

/** */
fun getFeaturePoolModules(): List<Module> = listOf(
)

/** */
fun getFeatureModules(): List<Module> = listOf(
    masterViewModule,
    detailModule,
)
