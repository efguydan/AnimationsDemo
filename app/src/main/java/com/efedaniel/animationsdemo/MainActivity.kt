package com.efedaniel.animationsdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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
        appBarConfiguration = AppBarConfiguration(topLevelDestinations)
    }

    fun setupToolbar(toolbarTitle: String) = supportActionBar!!.run {
        binding.toolbarLayout.toolbarTitleTextView.text = toolbarTitle
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
}
