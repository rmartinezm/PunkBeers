package cs.roberto.punkbeers.di

import cs.roberto.punkbeers.data.http_client.appHttpClientModule
import org.koin.core.module.Module

/** */
fun getDataModules(): List<Module> = listOf(
    appHttpClientModule,
)
