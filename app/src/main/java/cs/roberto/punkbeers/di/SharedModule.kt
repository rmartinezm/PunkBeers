package cs.roberto.punkbeers.di

import cs.roberto.shared.beer.beerModule
import cs.roberto.sharedpool.httpclient.httpClientModule
import cs.roberto.sharedpool.network.networkModule
import org.koin.core.module.Module

/** */
fun getSharedPoolModules(): List<Module> = listOf(
    httpClientModule,
    networkModule,
)

/** */
fun getSharedModules(): List<Module> = listOf(
    beerModule,
)