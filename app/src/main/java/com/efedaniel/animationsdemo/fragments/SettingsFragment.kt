package com.efedaniel.animationsdemo.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.efedaniel.animationsdemo.MainActivity
import com.efedaniel.animationsdemo.R

class SettingsFragment: PreferenceFragmentCompat() {

    private val mainActivity: MainActivity
        get() {
            return activity as? MainActivity ?: throw IllegalStateException("Not attached!")
        }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.app_settings, rootKey)
        mainActivity.setupToolbar(getString(R.string.settings), R.drawable.ic_arrow_back)
    }

}
