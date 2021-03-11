package cs.roberto.sharedpool.httpclient

import cs.roberto.sharedpool.httpclient.retrofit.RetrofitBuilder
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

/* */
val httpClientModule: Module = module {

    /* */
    single<Retrofit> {
        RetrofitBuilder(
            retrofitUrlProvider = get(),
        ).build()
    }

}