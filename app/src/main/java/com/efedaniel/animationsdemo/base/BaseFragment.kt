package com.efedaniel.animationsdemo.base

import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.efedaniel.animationsdemo.MainActivity
import com.efedaniel.animationsdemo.R

abstract class BaseFragment: Fragment() {

    protected val mainActivity: MainActivity
        get() {
            return activity as? MainActivity ?: throw IllegalStateException("Not attached!")
        }

    override fun onStart() {
        super.onStart()
        mainActivity.setCurrentFragment(this)
    }

    protected fun setupToolbar(
        title: String, @DrawableRes upIconRes: Int = R.drawable.ic_hamburger
    ) = mainActivity.setupToolbar(title, upIconRes)

    fun onBackPressed(): Boolean = false
}