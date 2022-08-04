package com.helloworldstudios.yemekgetir

import android.content.res.Resources
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.helloworldstudios.yemekgetir.databinding.FragmentSuccessfullyLoginSplashBinding
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule

class SuccessfullyLoginSplashFragment : Fragment() {

    private lateinit var binding: FragmentSuccessfullyLoginSplashBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_successfully_login_splash, container, false)
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
                findNavController().navigate(R.id.action_successfullyLoginSplashFragment_to_baseFragment)
            }

        }

        timer.start()

        return binding.root
    }
}