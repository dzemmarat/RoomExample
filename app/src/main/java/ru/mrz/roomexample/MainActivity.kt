package ru.mrz.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.mrz.roomexample.data.db.RecipesDb
import ru.mrz.roomexample.data.models.Ingredient
import ru.mrz.roomexample.data.models.Recipe
import ru.mrz.roomexample.data.pref.SharedPreferenceHelper
import ru.mrz.roomexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val recipesDao by lazy { RecipesDb.buildDataSource(this).recipesDao() }
    private val sharedPreferenceHelper by lazy { SharedPreferenceHelper(this) }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFirstTimeDatabase()
        setupTextViews()
    }

    private fun setupTextViews() {
        binding.tvName.text = recipesDao.getAllRecipes()[0].name
        recipesDao.getAllIngredients().forEach {
            binding.tvIngredients.text = binding.tvIngredients.text.toString() + "\n" + recipesDao.getIngredientById(it.id).name
        }
    }

    private fun setupFirstTimeDatabase() {
        if (sharedPreferenceHelper.isFirstStart) {
            setupIngredients()
            setupRecipes()
            sharedPreferenceHelper.isFirstStart = false
        }
    }
    private fun setupIngredients() {
        recipesDao.addIngredient(
            Ingredient(
                id = 1,
                name = "Мясо",
                caloric = 228
            )
        )
        recipesDao.addIngredient(
            Ingredient(
                id = 2,
                name = "Ahaha",
                caloric = 1337
            )
        )
    }

    private fun setupRecipes() {
        recipesDao.addRecipe(
            Recipe(
                name = "Ahaha с мясом",
                ingredientsId = listOf(1, 2)
            )
        )
    }
}