package com.example.filmler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmler.databinding.CardDesignFilmBinding
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext: Context, var filmList: List<Filmler>): RecyclerView.Adapter<FilmlerAdapter.CardDesignFilmHolder>() {
    inner class CardDesignFilmHolder(binding: CardDesignFilmBinding): RecyclerView.ViewHolder(binding.root){
        var binding: CardDesignFilmBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignFilmHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardDesignFilmBinding.inflate(layoutInflater, parent, false)
        return CardDesignFilmHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignFilmHolder, position: Int) {
        var film = filmList.get(position)
        val holderBinding = holder.binding
        holderBinding.ivFilm.setImageResource(
            mContext.resources.getIdentifier(film.filmResimAdi, "drawable", mContext.packageName))
        holderBinding.tvFilmTitle.text = film.filmAdi
        holderBinding.tvFilmPrice.text = "${film.filmFiyat} ₺"

        holderBinding.cardViewFilm.setOnClickListener {
            val gecis = HomeFragmentDirections.actionHomeFragmentToFilmDetailFragment(film)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return filmList.size
    }
}