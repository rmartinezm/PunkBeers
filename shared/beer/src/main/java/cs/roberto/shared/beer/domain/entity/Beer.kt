package cs.roberto.shared.beer.domain.entity

/** */
open class Beer(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val tagLine: String,
)

/** */
class BeerDetails(
    id: Int,
    name: String,
    imageUrl: String,
    tagLine: String,
    val description: String,
    val firstBrewedDate: String,
    val foodParing: List<String>,
) : Beer(id, name, imageUrl, tagLine)
