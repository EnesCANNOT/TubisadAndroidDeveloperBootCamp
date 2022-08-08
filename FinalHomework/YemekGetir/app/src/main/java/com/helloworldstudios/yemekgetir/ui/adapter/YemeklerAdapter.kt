package com.helloworldstudios.yemekgetir.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.helloworldstudios.yemekgetir.R
import com.helloworldstudios.yemekgetir.data.entity.Yemekler
import com.helloworldstudios.yemekgetir.databinding.ActivityBaseBinding
import com.helloworldstudios.yemekgetir.databinding.CardDesignHomeBinding
import com.helloworldstudios.yemekgetir.ui.fragment.HomeFragmentDirections
import com.helloworldstudios.yemekgetir.ui.viewmodel.HomeFragmentViewModel
import com.squareup.picasso.Picasso

class YemeklerAdapter(var mContext: Context, var yemekListesi: List<Yemekler>, var viewModel: HomeFragmentViewModel) : RecyclerView.Adapter<YemeklerAdapter.CardDesignHomeHolder>() {
    inner class CardDesignHomeHolder(binding: CardDesignHomeBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: CardDesignHomeBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHomeHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardDesignHomeBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_design_home, parent, false)
        return CardDesignHomeHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHomeHolder, position: Int) {
        val yemek = yemekListesi.get(position)
        holder.binding.yemekObject = yemek

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Picasso.get().load(url).into(holder.binding.ivYemekResim)

        holder.binding.cardYemek.setOnClickListener {
            val gecis = HomeFragmentDirections.actionHomeFragmentToYemekDetayFragment(yemek)
            Navigation.findNavController(it).navigate(gecis)

        }
    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }
}