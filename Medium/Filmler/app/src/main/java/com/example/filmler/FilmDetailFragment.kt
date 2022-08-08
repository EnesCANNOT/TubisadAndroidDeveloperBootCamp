package com.example.filmler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.filmler.databinding.FragmentFilmDetailBinding
import com.google.android.material.snackbar.Snackbar

class FilmDetailFragment : Fragment() {

    private lateinit var binding: FragmentFilmDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false)

        val bundle:FilmDetailFragmentArgs by navArgs()
        val gelenFilm = bundle.film

        binding.ivFilmResim.setImageResource(
            resources.getIdentifier(gelenFilm.filmResimAdi, "drawable", requireContext().packageName))
        binding.tvFilmYonetmen.text = gelenFilm.filmYonetmen
        binding.tvFilmYil.text = gelenFilm.filmYil.toString()
        binding.tvFilmFiyat.text = gelenFilm.filmFiyat.toString()

        binding.btnSepeteEkle.setOnClickListener {
            Snackbar.make(it, "${gelenFilm.filmAdi} sipariş verildi.", Snackbar.LENGTH_LONG).show()
        }

        return binding.root
    }
}