package com.example.filmler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmler.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.rvHomeFragment.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val filmlerListesi = ArrayList<Filmler>()

        var film1 = Filmler(1, "Anadoluda", "anadoluda", 2008, 7.0, "Nuri Bilge Ceylan")
        var film2 = Filmler(2, "Django", "django", 2010, 10.0, "Quentin Tarantino")
        var film3 = Filmler(3, "Inception", "inception", 2003, 14.0, "Christopher Nolan")
        var film4 = Filmler(4, "Interstellar", "interstellar", 2011, 12.0, "Christopher Nolan")
        var film5 = Filmler(5, "The Hateful Eight", "thehatefuleight", 2009, 17.0, "Quentin Tarantino")
        var film6 = Filmler(6, "The Pianist", "thepianist", 2001, 18.0, "Roman Polanski")

        filmlerListesi.add(film1)
        filmlerListesi.add(film2)
        filmlerListesi.add(film3)
        filmlerListesi.add(film4)
        filmlerListesi.add(film5)
        filmlerListesi.add(film6)

        val adapter = FilmlerAdapter(requireContext(), filmlerListesi)
        binding.rvHomeFragment.adapter = adapter


        return binding.root
    }
}