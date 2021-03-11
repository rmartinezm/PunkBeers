package cs.roberto.punkbeers.di

import cs.roberto.punkbeers.PunkBeersApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Initialize the Koin instance with the modules associated to the project.
 */
fun PunkBeersApplication.initKoin() {
    val sharedModules = getSharedPoolModules() + getSharedModules()
    val featureModules = getFeaturePoolModules() + getFeatureModules()
    val modules = sharedModules + featureModules
    startKoin{
        androidLogger()
        androidContext(this@initKoin)
        modules(modules)
    }
}
