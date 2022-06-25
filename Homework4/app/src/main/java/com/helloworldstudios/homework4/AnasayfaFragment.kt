package com.helloworldstudios.homework4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.helloworldstudios.homework4.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.buttonGoFragmentA.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.sayfaAFragment)
        }

        binding.buttonGoFragmentX.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sayfaBFragment)
        }

        return binding.root
    }
}