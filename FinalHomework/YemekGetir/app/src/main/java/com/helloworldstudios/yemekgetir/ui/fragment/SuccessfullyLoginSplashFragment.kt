package com.helloworldstudios.yemekgetir.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.helloworldstudios.yemekgetir.BaseActivity
import com.helloworldstudios.yemekgetir.R
import com.helloworldstudios.yemekgetir.databinding.FragmentSuccessfullyLoginSplashBinding
import java.util.*
import kotlin.concurrent.schedule

class SuccessfullyLoginSplashFragment : Fragment() {

    private lateinit var binding: FragmentSuccessfullyLoginSplashBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_successfully_login_splash, container, false)
        binding.successfullyLoginSplashFragmentObject = this

        var resources = context?.resources
        var animationDir1 = "login"
        var animationDir2 = "okey"
        var resourceId1 = resources?.getIdentifier(animationDir1, "raw", context?.packageName)
        var resourceId2 = resources?.getIdentifier(animationDir2, "raw", context?.packageName)
        context?.packageName

        binding.lottieLoginAnimation.setAnimation(resourceId1!!)
        binding.lottieLoginAnimation.playAnimation()

        Timer().schedule(6000) {
            binding.lottieLoginAnimation.setAnimation(resourceId2!!)
            binding.lottieLoginAnimation.playAnimation()
        }

        val timer = object : CountDownTimer(10000, 1000){
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                startActivity(Intent(requireActivity(), BaseActivity::class.java))
                requireActivity().finish()
            }

        }

        timer.start()

        return binding.root
    }
}