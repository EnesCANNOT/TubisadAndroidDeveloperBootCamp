package com.helloworldstudios.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.helloworldstudios.todoapp.R
import com.helloworldstudios.todoapp.databinding.FragmentAnasayfaBinding
import com.helloworldstudios.todoapp.ui.adapter.IslerAdapter
import com.helloworldstudios.todoapp.ui.viewmodel.AnasayfaFragmentViewModel
import com.helloworldstudios.todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        binding.anasayfaFragment = this
        binding.anasayfaToolbarBaslik = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)

        viewModel.islerListesi.observe(viewLifecycleOwner){
            val adapter = IslerAdapter(requireContext(), it, viewModel)
            binding.islerAdapter = adapter
        }

        return binding.root
    }

    fun fabClicked(view: View){
        Navigation.gecisYap(view, R.id.action_anasayfaFragment_to_kayitFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: AnasayfaFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.isleriYukle()
    }
}