package ru.mrz.roomexample.data.pref

import android.content.Context

class SharedPreferenceHelper(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    var isFirstStart
        get() = sharedPreferences.getBoolean(IS_FIRST_START, true)
        set(value) {
            sharedPreferences.edit().putBoolean(IS_FIRST_START, value).apply()
        }

    companion object {
        const val IS_FIRST_START = "is_first_start"
    }
}