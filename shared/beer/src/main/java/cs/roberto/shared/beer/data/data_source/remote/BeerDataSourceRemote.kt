package cs.roberto.shared.beer.data.data_source.remote

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import cs.roberto.core.clean.Either
import cs.roberto.shared.beer.data.BeerDataSource
import cs.roberto.shared.beer.data.data_source.remote.model.dto.BeerDetailsDto
import cs.roberto.shared.beer.domain.entity.BeerDetails
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsFailure
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsResponse
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersFailure
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersResponse
import cs.roberto.sharedpool.httpclient.retrofit.retrofitApiCall

/** */
internal class BeerDataSourceRemote(
    private val beerApiService: BeerApiService
) : BeerDataSource {

    /** */
    override suspend fun getBeers(
        page: Int,
        pageSize: Int
    ): Either<GetBeersFailure, GetBeersResponse> =
        try {
            retrofitApiCall { beerApiService.getBeers(page, pageSize) }.let {
                val beersDetailsDto = it.asBeersDetailsDto()
                val beers = beersDetailsDto.map { dto -> dto.toBeer() }
                val response = GetBeersResponse(beers)
                Either.Right(response)
            }
        } catch (exception: Exception) {
            val message: String = exception.message ?: exception.javaClass.simpleName
            val failure = GetBeersFailure.DetailFailure(message)
            Either.Left(failure)
        }

    /** */
    override suspend fun getBeerDetails(
        beerId: Int
    ): Either<GetBeerDetailsFailure, GetBeerDetailsResponse> =
        try {
            retrofitApiCall { beerApiService.getBeerDetails(beerId) }.let {
                val beersDetailsDto = it.asBeersDetailsDto()
                val beerDetailsDto: BeerDetailsDto = beersDetailsDto.first()
                val beerDetails: BeerDetails = beerDetailsDto.toBeerDetails()
                val response = GetBeerDetailsResponse(beerDetails)
                Either.Right(response)
            }
        } catch (exception: Exception) {
            val message: String = exception.message ?: exception.javaClass.simpleName
            val failure = GetBeerDetailsFailure.DetailFailure(message)
            Either.Left(failure)
        }

    /** */
    private fun Any.asBeersDetailsDto(): List<BeerDetailsDto> {
        val type = Types
            .newParameterizedType(MutableList::class.java, BeerDetailsDto::class.java)
        val beersDetailsJsonAdapter: JsonAdapter<List<BeerDetailsDto>> = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter(type)
        return beersDetailsJsonAdapter.fromJsonValue(this)!!
    }

}