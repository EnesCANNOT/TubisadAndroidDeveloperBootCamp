package com.helloworldstudios.yemekgetir.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.helloworldstudios.yemekgetir.R
import com.helloworldstudios.yemekgetir.databinding.FragmentCartBinding
import com.helloworldstudios.yemekgetir.ui.adapter.SepetYemeklerAdapter
import com.helloworldstudios.yemekgetir.ui.viewmodel.CartFragmentViewModel
import com.helloworldstudios.yemekgetir.ui.viewmodel.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartFragmentViewModel
    private lateinit var viewModelHome: HomeFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        binding.cartFragmentObject = this

        viewModel.sepetYemeklerListesi.observe(viewLifecycleOwner){
            val cartAdapter = SepetYemeklerAdapter(requireContext(), it, viewModel)
            binding.sepetYemeklerAdapter = cartAdapter

            var totalPrice = 0
            it.forEach{ yemek ->
                totalPrice += yemek.yemek_siparis_adet * yemek.yemek_fiyat
            }

            binding.tvTotalPrice.setText("${totalPrice.toString()} ₺")
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:CartFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonConfirmCart () {
        Toast.makeText(requireContext(), "Your cart has been confirmed", Toast.LENGTH_LONG).show()
    }

    fun deleteFood(yemek_id: Int){
        viewModel.sil(yemek_id)
    }
}