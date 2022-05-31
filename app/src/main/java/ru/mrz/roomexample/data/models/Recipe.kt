package ru.mrz.roomexample.data.models

import androidx.room.*

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "ingredientsId")
    val ingredientsId: List<Int>
)
