package com.efedaniel.animationsdemo

import android.os.Bundle
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
import kotlinx.android.synthetic.main.toolbar_layout.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var currentFragment: BaseFragment

    private var topLevelDestinations = setOf(R.id.propertyAnimationFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        //toolbar.overflowIcon = getDrawable()
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
        @DrawableRes upIconRes: Int = R.drawable.ic_hamburger
    ) = supportActionBar!!.run {
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
