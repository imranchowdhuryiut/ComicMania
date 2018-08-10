package com.coffietocode.comicapps.comicmania.data.repository

import android.content.SharedPreferences
import com.coffietocode.comicapps.comicmania.R
import com.coffietocode.comicapps.comicmania.utils.ThemeChooser
import javax.inject.Inject

/**
 * Created by Imran Chowdhury on 8/8/2018
 */
class PrefRepository @Inject
constructor(
        private val mSharedPreferences: SharedPreferences
){
    companion object {
        private const val APP_THEME = "APP_THEME"
    }

    private fun saveStringToSharedPreference(code: String, data: String) {
        val editor = mSharedPreferences.edit()
        editor.putString(code, data)
        editor.apply()
    }

    private fun getStringFromSharedPreference(code: String): String {
        return mSharedPreferences.getString(code, "")
    }

    fun getSavedTheme(): Int{
        val theme = getStringFromSharedPreference(APP_THEME)
        if (theme == ThemeChooser.DAEK_THEME) {
            return R.style.AppTheme_Dark
        }
        if (theme == ThemeChooser.DARKAMOLED_THEME) {
            return R.style.AppTheme_DarkAmoled
        }
        return R.style.AppTheme_White
    }

    fun saveAppTheme(themeName: String) {
        saveStringToSharedPreference(APP_THEME, themeName)
    }
}