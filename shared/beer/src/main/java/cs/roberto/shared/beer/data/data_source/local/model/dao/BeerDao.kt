package cs.roberto.shared.beer.data.data_source.local.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cs.roberto.shared.beer.data.data_source.local.model.entity.BeerEntity


@Dao
interface BeerDao {

    @Query("SELECT * FROM beer LIMIT :perPage OFFSET :page")
    suspend fun getBeers(
        page: Int,
        perPage: Int,
    ): List<BeerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(beers: List<BeerEntity>)

}