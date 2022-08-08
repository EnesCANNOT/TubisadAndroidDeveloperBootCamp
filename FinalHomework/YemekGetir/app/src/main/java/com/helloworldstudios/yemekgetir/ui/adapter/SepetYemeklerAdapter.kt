package com.helloworldstudios.yemekgetir.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.helloworldstudios.yemekgetir.R
import com.helloworldstudios.yemekgetir.data.entity.SepetYemekler
import com.helloworldstudios.yemekgetir.databinding.CardDesignCartBinding
import com.helloworldstudios.yemekgetir.ui.viewmodel.CartFragmentViewModel
import com.squareup.picasso.Picasso

class SepetYemeklerAdapter(var mContext: Context, var sepetYemekListesi: List<SepetYemekler>, var viewModel: CartFragmentViewModel) : RecyclerView.Adapter<SepetYemeklerAdapter.CardDesignCartHolder>(){
    inner class CardDesignCartHolder(binding: CardDesignCartBinding): RecyclerView.ViewHolder(binding.root){
        var binding: CardDesignCartBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignCartHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardDesignCartBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_design_cart, parent, false)
        return CardDesignCartHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignCartHolder, position: Int) {
        val sepettekiYemek = sepetYemekListesi.get(position)
        holder.binding.sepetYemeklerObject = sepettekiYemek

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepettekiYemek.yemek_resim_adi}"
        Picasso.get().load(url).into(holder.binding.ivYemekSepet)
        holder.binding.ivDelete.setOnClickListener {
            Snackbar.make(it,"${sepettekiYemek.yemek_adi} sepetten çıkarılsın mı?", Snackbar.LENGTH_LONG).setAction("EVET"){
                Snackbar.make(it,"${sepettekiYemek.yemek_adi} sepetten çıkarıldı.", Snackbar.LENGTH_LONG).show()
                viewModel.sepettekiYemekSil(sepettekiYemek.sepet_yemek_id, FirebaseAuth.getInstance().currentUser!!.email.toString())
                viewModel.sepettekiYemekleriYukle(FirebaseAuth.getInstance().currentUser!!.email.toString())
            }.show()
        }
    }

    override fun getItemCount(): Int {
        return sepetYemekListesi.size
    }
}