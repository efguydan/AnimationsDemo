package com.efedaniel.animationsdemo.fragments

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import com.efedaniel.animationsdemo.R
import com.efedaniel.animationsdemo.base.BaseFragment
import com.efedaniel.animationsdemo.databinding.FragmentDrawableAnimationBinding

class DrawableAnimationFragment : BaseFragment() {

    private lateinit var binding: FragmentDrawableAnimationBinding
    private lateinit var animation: AnimationDrawable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrawableAnimationBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar(getString(R.string.drawable_animation))
//        setHasOptionsMenu(true)

        binding.targetImage.setBackgroundResource(R.drawable.ic_signal_wifi_animation)
        animation = binding.targetImage.background as AnimationDrawable

        binding.rootLayout.setOnClickListener {
            if (animation.isRunning) animation.stop() else animation.start()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

}
