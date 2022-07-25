package com.helloworldstudios.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.helloworldstudios.todoapp.R
import com.helloworldstudios.todoapp.databinding.FragmentKayitBinding
import com.helloworldstudios.todoapp.ui.viewmodel.KayitFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {

    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kayit, container, false)
        binding.kayitFragment = this
        binding.isKayitToolbarBaslik = "Yapılacak İş Kayıt"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KayitFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(yapilacak_is: String){
        viewModel.kayit(yapilacak_is)
    }

}