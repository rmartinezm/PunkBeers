package cs.roberto.shared.beer.data.data_source.local.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cs.roberto.shared.beer.domain.entity.Beer

@Entity(tableName = "beer")
data class BeerEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "tagline") val tagLine: String,
) {

    /** */
    fun toBeer(): Beer =
        Beer(id, name, imageUrl, tagLine)

    /** */
    companion object {

        /** */
        fun fromBeer(beer: Beer): BeerEntity =
            BeerEntity(beer.id, beer.name, beer.imageUrl, beer.tagLine)

    }

}