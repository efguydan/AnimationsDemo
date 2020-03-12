package com.efedaniel.animationsdemo.fragments

import android.animation.Animator
import android.animation.AnimatorInflater
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.efedaniel.animationsdemo.R
import com.efedaniel.animationsdemo.base.BaseFragment
import com.efedaniel.animationsdemo.databinding.FragmentPropertyAnimationBinding

class PropertyAnimationFragment : BaseFragment() {

    private lateinit var binding: FragmentPropertyAnimationBinding
    private lateinit var animator: Animator

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

        //TODO To set up completely later
        animator = AnimatorInflater.loadAnimator(mainActivity, R.animator.property_rotate)
        animator.setTarget(binding.targetImage)
        binding.rootLayout.setOnClickListener {
            animator.start()
        }
    }
}
