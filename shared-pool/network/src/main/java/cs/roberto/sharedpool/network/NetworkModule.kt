package cs.roberto.sharedpool.network

import cs.roberto.sharedpool.network.repository.NetworkConnectionRepository
import cs.roberto.sharedpool.network.repository.NetworkConnectionRepositoryImpl
import cs.roberto.sharedpool.network.repository.data.NetworkConnectionApiService
import cs.roberto.sharedpool.network.repository.data.NetworkConnectionRetrofitBuilder
import org.koin.core.component.KoinApiExtension
import org.koin.core.module.Module
import org.koin.dsl.module

/* */
val networkModule: Module = module {

    /* */
    single<NetworkConnectionRepository>(createdAtStart = true) {
        NetworkConnectionRepositoryImpl()
    }

    /* */
    single<NetworkConnectionApiService> {
        NetworkConnectionRetrofitBuilder()
            .build()
            .create(NetworkConnectionApiService::class.java)
    }

}