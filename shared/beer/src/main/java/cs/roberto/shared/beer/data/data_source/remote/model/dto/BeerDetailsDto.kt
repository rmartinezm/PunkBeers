package cs.roberto.shared.beer.data.data_source.remote.model.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import cs.roberto.shared.beer.domain.entity.BeerDetails

/** */
@JsonClass(generateAdapter = true)
internal data class BeerDetailsDto(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "image_url") val imageUrl: String,
    @Json(name = "tagline") val tagLine: String,
    @Json(name = "description") val description: String,
    @Json(name = "first_brewed") val firstBrewedDate: String,
    @Json(name = "food_pairing") val foodParing: List<String>,
) {

    /** */
    fun toBeerDetails(): BeerDetails =
        BeerDetails(id, name, imageUrl, tagLine, description, firstBrewedDate, foodParing)

}