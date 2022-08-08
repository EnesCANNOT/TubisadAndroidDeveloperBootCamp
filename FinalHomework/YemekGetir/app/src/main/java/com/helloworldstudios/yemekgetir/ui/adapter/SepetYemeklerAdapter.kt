package com.helloworldstudios.yemekgetir.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.helloworldstudios.yemekgetir.data.entity.SepetYemekler
import com.helloworldstudios.yemekgetir.data.entity.Yemekler
import com.helloworldstudios.yemekgetir.databinding.CardDesignCartBinding
import com.helloworldstudios.yemekgetir.ui.viewmodel.CartFragmentViewModel
import com.helloworldstudios.yemekgetir.ui.viewmodel.HomeFragmentViewModel
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
        val binding = CardDesignCartBinding.inflate(layoutInflater, parent, false)
        return CardDesignCartHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignCartHolder, position: Int) {
        val yemek = sepetYemekListesi.get(position)
        holder.binding.sepetYemeklerObject = yemek

//        var alinanSiparisAdedi = holder.binding.tvYemekAdetFiyatCart.text.toString()
//        var yemek_siparis_adet = alinanSiparisAdedi.toInt()

//        holder.binding.tvYemekAdCart.text = "${yemek.yemek_adi}"
//        holder.binding.tvYemekAdetCart.text = "${yemek.yemek_siparis_adet} adet"
//        holder.binding.tvYemekFiyatCart.text = "₺ ${(yemek.yemek_siparis_adet * yemek.yemek_fiyat)}"

        Log.e("Look", "Buradayım")

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Picasso.get().load(url).into(holder.binding.ivYemekResimCart)
        holder.binding.ivDelete.setOnClickListener {
            Snackbar.make(it,"${yemek.yemek_adi} sepetten çıkarılsın mı?", Snackbar.LENGTH_LONG).setAction("EVET"){
                Snackbar.make(it,"${yemek.yemek_adi} sepetten çıkarıldı.", Snackbar.LENGTH_LONG).show()
                viewModel.sil(yemek.sepet_yemek_id)
                viewModel.yrepo.tumSepetiGoster()
            }.show()
        }
    }

    override fun getItemCount(): Int {
        return sepetYemekListesi.size
    }
}