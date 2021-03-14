package cs.roberto.shared.beer.data.data_source.local

import cs.roberto.core.clean.Either
import cs.roberto.shared.beer.data.BeerDataSource
import cs.roberto.shared.beer.data.data_source.local.model.dao.BeerDao
import cs.roberto.shared.beer.data.data_source.local.model.dao.BeerDetailsDao
import cs.roberto.shared.beer.data.data_source.local.model.entity.BeerDetailsEntity
import cs.roberto.shared.beer.data.data_source.local.model.entity.BeerEntity
import cs.roberto.shared.beer.domain.entity.Beer
import cs.roberto.shared.beer.domain.entity.BeerDetails
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsFailure
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsResponse
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersFailure
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersResponse

/** */
internal class BeerDataSourceLocal(
    private val beerDao: BeerDao,
    private val beerDetailsDao: BeerDetailsDao,
) : BeerDataSource {

    /** */
    override suspend fun getBeers(
        page: Int,
        pageSize: Int
    ): Either<GetBeersFailure, GetBeersResponse> {
        val tableSize = beerDao.getTableSize()
        val beers = if (tableSize >= page * pageSize)
            beerDao.getBeers(page.dec(), pageSize).map(BeerEntity::toBeer)
        else emptyList()
        val response = GetBeersResponse(beers)
        return Either.Right(response)
    }

    /** */
    suspend fun saveBeers(beers: List<Beer>) {
        val beersEntity = beers.map(BeerEntity.Companion::fromBeer)
        beerDao.insertAll(beersEntity)
    }

    /** */
    override suspend fun getBeerDetails(
        beerId: Int
    ): Either<GetBeerDetailsFailure, GetBeerDetailsResponse> {
        val beerDetailsEntity = beerDetailsDao.getBeerDetails(beerId)
            ?: return Either.Left(GetBeerDetailsFailure.NetworkConnectionFailure)
        val beerDetails = beerDetailsEntity.toBeerDetails()
        val response = GetBeerDetailsResponse(beerDetails)
        return Either.Right(response)
    }

    /** */
    suspend fun saveBeerDetails(beerDetails: BeerDetails) {
        val beerDetailsEntity = BeerDetailsEntity.fromBeerDetails(beerDetails)
        beerDetailsDao.insert(beerDetailsEntity)
    }

}