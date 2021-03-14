package cs.roberto.shared.beer.data.data_source.local.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cs.roberto.shared.beer.domain.entity.BeerDetails

@Entity(tableName = "beer_details")
data class BeerDetailsEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "tagline") val tagLine: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "first_brewed") val firstBrewedDate: String,
    @ColumnInfo(name = "food_pairing") val foodParing: List<String>,
) {

    /** */
    fun toBeerDetails(): BeerDetails =
        BeerDetails(id, name, imageUrl, tagLine, description, firstBrewedDate, foodParing)

    /** */
    companion object {

        /** */
        fun fromBeerDetails(beerDetails: BeerDetails): BeerDetailsEntity =
            BeerDetailsEntity(
                beerDetails.id,
                beerDetails.name,
                beerDetails.imageUrl,
                beerDetails.tagLine,
                beerDetails.description,
                beerDetails.firstBrewedDate,
                beerDetails.foodParing,
            )

    }

}