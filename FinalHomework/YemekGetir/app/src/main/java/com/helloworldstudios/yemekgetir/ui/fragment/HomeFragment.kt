package com.helloworldstudios.yemekgetir.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.helloworldstudios.yemekgetir.R
import com.helloworldstudios.yemekgetir.databinding.FragmentHomeBinding
import com.helloworldstudios.yemekgetir.ui.adapter.YemeklerAdapter
import com.helloworldstudios.yemekgetir.ui.viewmodel.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(){

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.homeFragmentObject = this

        viewModel.yemeklerListesi.observe(viewLifecycleOwner){
            val adapter = YemeklerAdapter(requireContext(), it, viewModel)
            binding.yemeklerAdapter = adapter
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.ara(newText!!)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:HomeFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fiyatAzalan(){
        viewModel.sortByAscendingPrice()
    }

    fun fiyatArtan(){
        viewModel.sortByDescendingPrice()
    }

    fun buttonA_Z(){
        viewModel.sortA_Z()
    }

    fun buttonZ_A(){
        viewModel.sortZ_A()
    }
}