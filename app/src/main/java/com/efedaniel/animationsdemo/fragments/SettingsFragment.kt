package com.efedaniel.animationsdemo.fragments

import android.os.Bundle
import android.util.Log
import androidx.preference.ListPreference
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
    }

    override fun onStart() {
        super.onStart()
        mainActivity.setupToolbar(getString(R.string.settings), R.drawable.ic_arrow_back)
        setupListeners()
    }

    private fun setupListeners() {
        findPreference<ListPreference>("ui_mode")!!.setOnPreferenceChangeListener { _, newValue ->
            mainActivity.setThemeMode(newValue as String)
            true
        }
    }

}
