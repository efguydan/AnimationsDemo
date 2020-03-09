package com.efedaniel.animationsdemo.base

import androidx.fragment.app.Fragment
import com.efedaniel.animationsdemo.MainActivity

abstract class BaseFragment: Fragment() {

    private val mainActivity: MainActivity
        get() {
            return activity as? MainActivity ?: throw IllegalStateException("Not attached!")
        }

    override fun onStart() {
        super.onStart()
        mainActivity.setCurrentFragment(this)
    }

    protected fun setupToolbar(title: String) = mainActivity.setupToolbar(title)

    fun onBackPressed(): Boolean = false

}