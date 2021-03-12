package cs.roberto.shared.beer.data.data_source.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/** */
internal interface BeerApiService {

    /** */
    @GET(URL.GET_BEERS)
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 20,
    ): Response<Any>

    /** */
    @GET(URL.GET_BEER_DETAILS)
    suspend fun getBeerDetails(
        @Path("beer_id") beerId: Int,
    ): Response<Any>

    /** */
    private object URL {

        /* */
        const val GET_BEERS: String = "beers"

        /* */
        const val GET_BEER_DETAILS: String = "beers/{beer_id}"

    }

}