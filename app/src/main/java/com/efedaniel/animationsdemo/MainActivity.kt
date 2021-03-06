package com.efedaniel.animationsdemo

import android.os.Bundle
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.efedaniel.animationsdemo.base.BaseFragment
import com.efedaniel.animationsdemo.databinding.ActivityMainBinding
import com.efedaniel.animationsdemo.utils.PrefsUtils
import com.efedaniel.animationsdemo.utils.PrefsUtils.Companion.getPrefsUtils
import kotlinx.android.synthetic.main.toolbar_layout.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var currentFragment: BaseFragment

    private var topLevelDestinations = setOf(
        R.id.propertyAnimationFragment,
        R.id.interpolatorFragment,
        R.id.drawableAnimationFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setThemeMode(getPrefsUtils(applicationContext).getString("ui_mode", "Light Theme"))
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        binding.toolbarLayout.toolbar.overflowIcon = getDrawable(R.drawable.ic_overflow)
        setSupportActionBar(binding.toolbarLayout.toolbar)
        supportActionBar!!.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
            setHomeAsUpIndicator(R.drawable.ic_hamburger)
        }
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(topLevelDestinations, binding.drawerLayout)
        setupNavBar()
    }

    private fun setupNavBar() {
        NavigationUI.setupWithNavController(binding.navigationView, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.drawerLayout.setDrawerLockMode(
                if (topLevelDestinations.contains(destination.id)) DrawerLayout.LOCK_MODE_UNLOCKED
                else DrawerLayout.LOCK_MODE_LOCKED_CLOSED
            )
        }
    }

    fun setupToolbar(
        toolbarTitle: String,
        @DrawableRes upIconRes: Int = R.drawable.ic_hamburger) = supportActionBar!!.run {
        binding.toolbarLayout.toolbarTitleTextView.text = toolbarTitle
        supportActionBar!!.setHomeAsUpIndicator(upIconRes)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    fun setCurrentFragment(fragment: BaseFragment) {
        currentFragment = fragment
    }

    override fun onBackPressed() {
        if (!currentFragment.onBackPressed()) super.onBackPressed()
    }

    fun setThemeMode(themeMode: String) = AppCompatDelegate.setDefaultNightMode(
        when(themeMode) {
            "Light Theme" -> AppCompatDelegate.MODE_NIGHT_NO
            "Dark Theme" -> AppCompatDelegate.MODE_NIGHT_YES
            "Follow System" -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            "Set by Battery Saver" -> AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
            else -> AppCompatDelegate.MODE_NIGHT_NO
        })
}
