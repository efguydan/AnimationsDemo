package com.efedaniel.animationsdemo.fragments

import android.animation.Animator
import android.animation.AnimatorInflater
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.AnimatorRes
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment

import com.efedaniel.animationsdemo.R
import com.efedaniel.animationsdemo.base.BaseFragment
import com.efedaniel.animationsdemo.databinding.FragmentPropertyAnimationBinding

class PropertyAnimationFragment : BaseFragment() {

    private lateinit var binding: FragmentPropertyAnimationBinding
    private lateinit var animator: Animator

    @AnimatorRes private var animatorRes: Int = R.animator.property_alpha

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPropertyAnimationBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar(getString(R.string.property_animation))
        setHasOptionsMenu(true)
        binding.rootLayout.setOnClickListener {
            animator = AnimatorInflater.loadAnimator(mainActivity, animatorRes)
            animator.run {
                setTarget(binding.targetImage)
                start()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.property_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.alpha -> {
                animatorRes = R.animator.property_alpha
                true
            }
            R.id.rotate -> {
                animatorRes = R.animator.property_rotate
                true
            }
            R.id.scale -> {
                animatorRes = R.animator.property_scale
                true
            }
            R.id.translate -> {
                animatorRes = R.animator.property_translate
                true
            }
            else -> false
        }
    }
}
