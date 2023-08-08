package ru.alexandrorlov.surf_test.data.local

import androidx.room.TypeConverter
import ru.alexandrorlov.surf_test.config.Constant.SEPARATE_SYMBOL

class Converters {
    @TypeConverter
    fun mapStringToList(string: String): List<String> {
        return string.split(SEPARATE_SYMBOL)
    }

    @TypeConverter
    fun mapListToString(list: List<String>): String {
        return list.joinToString(SEPARATE_SYMBOL)
    }
}