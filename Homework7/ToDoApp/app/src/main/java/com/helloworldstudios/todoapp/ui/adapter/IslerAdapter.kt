package com.helloworldstudios.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.helloworldstudios.todoapp.R
import com.helloworldstudios.todoapp.data.entity.Isler
import com.helloworldstudios.todoapp.databinding.CardDesignBinding
import com.helloworldstudios.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.helloworldstudios.todoapp.ui.viewmodel.AnasayfaFragmentViewModel
import com.helloworldstudios.todoapp.utils.gecisYap

class IslerAdapter(var mContext: Context, var islerListesi: List<Isler>, var viewModel: AnasayfaFragmentViewModel): RecyclerView.Adapter<IslerAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(binding: CardDesignBinding): RecyclerView.ViewHolder(binding.root){
        var binding: CardDesignBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardDesignBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_design, parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val yapilacakIs = islerListesi.get(position)
        holder.binding.isNesnesi = yapilacakIs

        holder.binding.satirCard.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(yapilacakIs = yapilacakIs)
            Navigation.gecisYap(it, gecis)
        }

        holder.binding.ivDelete.setOnClickListener {
            Snackbar.make(it, "\"${yapilacakIs.yapilacak_is}\" işini yapılacaklar listesinden kaldırmak istiyor musun?", Snackbar.LENGTH_INDEFINITE)
                .setAction("Evet"){
                    viewModel.sil(yapilacakIs.yapilacak_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return islerListesi.size
    }
}