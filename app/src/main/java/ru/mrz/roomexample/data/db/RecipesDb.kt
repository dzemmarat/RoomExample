package ru.mrz.roomexample.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.mrz.roomexample.data.converter.ListsConverter
import ru.mrz.roomexample.data.dao.RecipesDao
import ru.mrz.roomexample.data.db.RecipesDb.Companion.DATABASE_VERSION
import ru.mrz.roomexample.data.models.Ingredient
import ru.mrz.roomexample.data.models.Recipe

@Database(
    entities = [
        Recipe::class,
        Ingredient::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(ListsConverter::class)
abstract class RecipesDb : RoomDatabase() {
    abstract fun recipesDao(): RecipesDao

    companion object {
        const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Recipes-Room"

        fun buildDataSource(context: Context): RecipesDb =
            Room.databaseBuilder(context, RecipesDb::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }
}