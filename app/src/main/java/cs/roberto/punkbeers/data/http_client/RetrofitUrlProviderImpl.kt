package cs.roberto.punkbeers.data.http_client

import cs.roberto.punkbeers.BuildConfig
import cs.roberto.sharedpool.httpclient.retrofit.RetrofitUrlProvider

/** */
class RetrofitUrlProviderImpl : RetrofitUrlProvider {

    /** */
    override fun getBaseUrl(): String =
        BuildConfig.API_BASE_URL

}