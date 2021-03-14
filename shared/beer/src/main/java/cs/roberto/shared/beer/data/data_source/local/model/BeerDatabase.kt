package cs.roberto.shared.beer.data.data_source.local.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cs.roberto.shared.beer.data.data_source.local.model.converter.ListStringConverter
import cs.roberto.shared.beer.data.data_source.local.model.dao.BeerDao
import cs.roberto.shared.beer.data.data_source.local.model.dao.BeerDetailsDao
import cs.roberto.shared.beer.data.data_source.local.model.entity.BeerDetailsEntity
import cs.roberto.shared.beer.data.data_source.local.model.entity.BeerEntity

@Database(
    entities = [
        BeerEntity::class,
        BeerDetailsEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListStringConverter::class)
abstract class BeerDatabase : RoomDatabase() {

    /** */
    abstract fun beerDao(): BeerDao

    /** */
    abstract fun beerDetailsDao(): BeerDetailsDao

    /** */
    companion object {

        @Volatile
        private var INSTANCE: BeerDatabase? = null

        /** */
        fun getDatabase(context: Context): BeerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BeerDatabase::class.java,
                    "beer_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}