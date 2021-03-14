package cs.roberto.shared.beer

import cs.roberto.shared.beer.data.BeerRepositoryImpl
import cs.roberto.shared.beer.data.data_source.local.BeerDataSourceLocal
import cs.roberto.shared.beer.data.data_source.local.model.BeerDatabase
import cs.roberto.shared.beer.data.data_source.local.model.dao.BeerDao
import cs.roberto.shared.beer.data.data_source.local.model.dao.BeerDetailsDao
import cs.roberto.shared.beer.data.data_source.remote.BeerApiService
import cs.roberto.shared.beer.data.data_source.remote.BeerDataSourceRemote
import cs.roberto.shared.beer.domain.BeerRepository
import cs.roberto.shared.beer.domain.use_case.get_beer_details.GetBeerDetailsUseCase
import cs.roberto.shared.beer.domain.use_case.get_beers.GetBeersUseCase
import cs.roberto.shared.beer.presentation.get_beer_details.GetBeerDetails
import cs.roberto.shared.beer.presentation.get_beer_details.GetBeerDetailsImpl
import cs.roberto.shared.beer.presentation.get_beers.GetBeers
import cs.roberto.shared.beer.presentation.get_beers.GetBeersImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

/* */
val beerModule: Module = module {

    /** PRESENTATION */
    single<GetBeers> { GetBeersImpl(getBeersUseCase = get()) }
    single<GetBeerDetails> { GetBeerDetailsImpl(getBeerDetailsUseCase = get()) }

    /** USE CASE */
    factory { GetBeersUseCase(beerRepository = get()) }
    factory { GetBeerDetailsUseCase(beerRepository = get()) }

    /** REPOSITORY */
    single<BeerRepository> {
        BeerRepositoryImpl(
            beerDataSourceLocal = get(),
            beerDataSourceRemote = get(),
            networkConnectionRepository = get(),
        )
    }

    /** DATA SOURCE */
    /* LOCAL */
    single {
        BeerDataSourceLocal(
            beerDao = get(),
            beerDetailsDao = get(),
        )
    }
    /* REMOTE */
    single {
        BeerDataSourceRemote(
            beerApiService = get(),
        )
    }

    /** DAO */
    /* BEER */
    single<BeerDao> {
        BeerDatabase
            .getDatabase(androidApplication())
            .beerDao()
    }
    /* BEER DETAILS */
    single<BeerDetailsDao> {
        BeerDatabase
            .getDatabase(androidApplication())
            .beerDetailsDao()
    }

    /** API SERVICE */
    single<BeerApiService> {
        get<Retrofit>().create(BeerApiService::class.java)
    }

}