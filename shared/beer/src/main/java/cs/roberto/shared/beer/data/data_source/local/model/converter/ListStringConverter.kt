package cs.roberto.shared.beer.data.data_source.local.model.converter

import androidx.room.TypeConverter

/** */
class ListStringConverter {

    @TypeConverter
    fun fromStringToList(value: String): List<String> =
        value.split(",")

    @TypeConverter
    fun listToString(value: List<String>): String =
        value.joinToString()

}