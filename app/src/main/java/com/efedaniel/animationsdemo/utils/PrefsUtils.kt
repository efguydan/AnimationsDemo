package com.efedaniel.animationsdemo.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class PrefsUtils(
    private val context: Context
) {

    companion object {
        private var prefsUtils: PrefsUtils? = null

        fun getPrefsUtils(context: Context): PrefsUtils {
            if (prefsUtils == null)
                prefsUtils = PrefsUtils(context)
            return prefsUtils!!
        }
    }

    private val sharedPrefs: SharedPreferences
        get() {
            return PreferenceManager.getDefaultSharedPreferences(context)
        }

    fun getString(key: String, defaultValue: String): String {
        return sharedPrefs.getString(key, defaultValue) ?: defaultValue
    }

}