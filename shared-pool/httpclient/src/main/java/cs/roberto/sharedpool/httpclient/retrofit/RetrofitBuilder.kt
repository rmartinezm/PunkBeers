package cs.roberto.sharedpool.httpclient.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/** */
class RetrofitBuilder(
    private val retrofitUrlProvider: RetrofitUrlProvider,
) {

    /* */
    private val timeOut: Long = 100L


    /** */
    fun build(): Retrofit {
        val baseUrl = retrofitUrlProvider.getBaseUrl()
        val moshiConverterFactory = MoshiConverterFactory.create()
        return Retrofit.Builder()
            .client(buildHttpClient())
            .baseUrl(baseUrl)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    /** */
    private fun buildHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .addBodyInterceptor()
            .build()

    /** */
    private fun OkHttpClient.Builder.addBodyInterceptor(): OkHttpClient.Builder {
        val bodyInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        addInterceptor(bodyInterceptor)
        return this
    }

}