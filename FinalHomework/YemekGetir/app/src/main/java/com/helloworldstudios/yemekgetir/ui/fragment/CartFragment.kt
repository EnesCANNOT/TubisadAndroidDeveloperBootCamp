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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        binding.cartFragmentObject = this


        binding.tvTotalPrice.visibility = View.INVISIBLE
        binding.tvTotal.visibility = View.INVISIBLE
        binding.buttonConfirmCart.visibility = View.INVISIBLE

        viewModel.sepettekiYemekListesi.observe(viewLifecycleOwner){
            val cartAdapter = SepetYemeklerAdapter(requireContext(), it, viewModel)
            binding.sepetYemeklerAdapter = cartAdapter

            var totalPrice = 0
            it.forEach{ yemek ->
                totalPrice += yemek.yemek_siparis_adet * yemek.yemek_fiyat
            }

            viewModel.sepettekiYemekListesi.observe(viewLifecycleOwner) {
                if (it.isEmpty()) {
                    binding.recyclerView.visibility= View.INVISIBLE
                    binding.tvTotalPrice.visibility = View.INVISIBLE
                    binding.tvTotal.visibility = View.INVISIBLE
                    binding.buttonConfirmCart.visibility = View.INVISIBLE
                    binding.anim.visibility = View.VISIBLE
                    binding.sepetBos.visibility = View.VISIBLE
                } else {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.tvTotalPrice.visibility = View.VISIBLE
                    binding.tvTotal.visibility = View.VISIBLE
                    binding.buttonConfirmCart.visibility = View.VISIBLE
                    binding.anim.visibility = View.INVISIBLE
                    binding.sepetBos.visibility = View.INVISIBLE
                }
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
        Toast.makeText(requireContext(), "Sepetiniz onaylandı!", Toast.LENGTH_LONG).show()
        //viewModel.tumYemekleriSil()
    }
}