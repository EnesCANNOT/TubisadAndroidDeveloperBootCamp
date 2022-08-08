package com.helloworldstudios.yemekgetir.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import com.helloworldstudios.yemekgetir.R
import com.helloworldstudios.yemekgetir.databinding.FragmentYemekDetayBinding
import com.helloworldstudios.yemekgetir.ui.viewmodel.YemekDetayFragmentViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YemekDetayFragment : Fragment() {

    private lateinit var binding: FragmentYemekDetayBinding
    private lateinit var viewModel: YemekDetayFragmentViewModel

    var adet = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_detay, container, false)
        binding.yemekDetayFragmentObject = this

        val bundle: YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek

        viewModel.yemekAdi = gelenYemek.yemek_adi
        binding.gelenYemek = gelenYemek

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${gelenYemek.yemek_resim_adi}"
        Picasso.get().load(url).into(binding.ivYemekDetayFragment)

        binding.tvYemekAdDetayFragment.text = gelenYemek.yemek_adi
        binding.tvYemekFiyatDetayFragment.text = "${gelenYemek.yemek_fiyat} ₺"
        binding.yemekSiparisAdet.text = "${adet}"


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YemekDetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun yemekAdetArti() {
        var yemekAdet = Integer.parseInt(binding.yemekSiparisAdet.text.toString())
        binding.yemekSiparisAdet.text = (yemekAdet + 1).toString()
    }

    fun yemekAdetEksi() {
        var yemekAdet = Integer.parseInt(binding.yemekSiparisAdet.text.toString())
        if (yemekAdet > 1){
            binding.yemekSiparisAdet.text = (yemekAdet - 1).toString()
        } else{
            Toast.makeText(requireContext(), "Amount can not be 0", Toast.LENGTH_LONG).show()
        }

    }

    fun buttonAddToCart(yemek_adi: String, yemek_resim_adi: String, yemek_fiyat: Int, yemek_siparis_adet: Int){
        viewModel.addToCart(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, FirebaseAuth.getInstance().currentUser!!.email.toString())
        Toast.makeText(requireContext(), (yemek_siparis_adet.toString() + " adet " + yemek_adi.toString() + " sepete eklendi."), Toast.LENGTH_LONG).show()
        Navigation.findNavController(requireView()).navigate(R.id.action_yemekDetayFragment_to_homeFragment)
    }
}