package ru.mrz.roomexample.data.converter

import androidx.room.TypeConverter

class ListsConverter {
    @TypeConverter
    fun fromListString(hobbies: List<Int?>): String {
        return hobbies.joinToString(",")
    }

    @TypeConverter
    fun toListString(data: String): List<Int> {
        return data.split(",").map { it.toInt() }
    }
}