package cs.roberto.shared.beer.data.data_source.local.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cs.roberto.shared.beer.data.data_source.local.model.entity.BeerDetailsEntity

@Dao
interface BeerDetailsDao {

    @Query("SELECT * FROM beer_details WHERE id LIKE :id")
    suspend fun getBeerDetails(id: Int): BeerDetailsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(beerDetailsEntity: BeerDetailsEntity)

}