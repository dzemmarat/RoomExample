package ru.mrz.roomexample.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.mrz.roomexample.data.models.Ingredient
import ru.mrz.roomexample.data.models.Recipe

@Dao
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): List<Recipe>

    @Query("SELECT * FROM ingredient")
    fun getAllIngredients(): List<Ingredient>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addIngredient(ingredient: Ingredient)

    @Query("SELECT * FROM ingredient WHERE id = :id")
    fun getIngredientById(id: Int): Ingredient
}