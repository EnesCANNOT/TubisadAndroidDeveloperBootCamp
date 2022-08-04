package com.helloworldstudios.yemekgetir

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.snackbar.Snackbar
import com.helloworldstudios.yemekgetir.databinding.FragmentBaseBinding


class BaseFragment : Fragment() {

    private lateinit var binding: FragmentBaseBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_base, container, false)
        binding.baseFragmentObject = this
        onBackPressed()
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home -> {replaceFragment(HomeFragment())}
                R.id.cart -> {replaceFragment(CartFragment())}
                R.id.profile -> {replaceFragment(ProfileFragment())}

                else -> {}
            }

            true
        }
        return binding.root
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun onBackPressed(){
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            Snackbar.make(requireView(), "Exit the app?", Snackbar.LENGTH_LONG).setAction("Yes"){
                requireActivity().finish()
            }.show()
        }
    }
}