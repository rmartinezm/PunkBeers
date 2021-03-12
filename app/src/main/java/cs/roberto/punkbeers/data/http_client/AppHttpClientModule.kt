package cs.roberto.punkbeers.data.http_client

import cs.roberto.sharedpool.httpclient.retrofit.RetrofitUrlProvider
import org.koin.core.module.Module
import org.koin.dsl.module

/* */
val appHttpClientModule: Module = module {

    /* */
    single<RetrofitUrlProvider> {
        RetrofitUrlProviderImpl()
    }

}