package cs.roberto.shared.beer.data.data_source.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/** */
internal interface BeerApiService {

    /** */
    @GET(URL.GET_BEER_DETAILS)
    suspend fun getBeerDetails(
        @Path("beer_id") beerId: Int,
    ): Response<Any>

    /** */
    private object URL {

        /* */
        const val GET_BEER_DETAILS: String = "beers/{beer_id}"

    }

}