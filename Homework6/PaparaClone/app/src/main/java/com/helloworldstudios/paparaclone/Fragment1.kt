package com.helloworldstudios.paparaclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.helloworldstudios.paparaclone.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)

        binding.rvContactsAsUser.layoutManager = LinearLayoutManager(requireContext())
        binding.rvContactsAsNotUser.layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuickLink.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        val quickLinkList = ArrayList<User>()
        val paparaUserList = ArrayList<User>()
        val notPaparaUserList = ArrayList<User>()

        //var user1 = User("Alexandre Alekhine", "+908503500350", "alexandre_alekhine")
        var user1 = User("Alexandre", "+908503500350", "alexandre_alekhine")
        //var user2 = User("Betül Cemre Yıldız", "+908503500350", "betul_cemre_yildiz")
        var user2 = User("Betül", "+908503500350", "betul_cemre_yildiz")
        var user3 = User("Ekaterina Atalık", "+908503400350", "ekaterina_atalik")
        //var user4 = User("Magnus Carlsen", "+908503300350", "magnus")
        var user4 = User("Magnus", "+908503300350", "magnus")
        var user5 = User("Suat Atalık", "+908503400350", "suat_atalik")
        var user6 = User("Wilhelm Steinitz", "+908503500350", "wilhelm_steinitz")

        quickLinkList.add(user1)
        quickLinkList.add(user2)
        quickLinkList.add(user4)

        paparaUserList.add(user3)
        paparaUserList.add(user5)

        notPaparaUserList.add(user6)

        binding.tvQuickLink.text = (binding.tvQuickLink.text.toString() + " • " + quickLinkList.size.toString())
        binding.tvPaparaUser.text = (binding.tvPaparaUser.text.toString() + " • " + paparaUserList.size.toString())
        binding.tvNotPaparaUser.text = (binding.tvNotPaparaUser.text.toString() + " • " + notPaparaUserList.size.toString())

        val adapterForPaparaUserList = ContactAdapter(requireContext(), paparaUserList)
        binding.rvContactsAsUser.adapter = adapterForPaparaUserList

        val adapterForNotPaparaUserList = ContactAdapter(requireContext(), notPaparaUserList)
        binding.rvContactsAsNotUser.adapter = adapterForNotPaparaUserList

        val adapterForQuickLinkUserList = QuickLinkAdapter(requireContext(), quickLinkList)
        binding.rvQuickLink.adapter = adapterForQuickLinkUserList

        return binding.root
    }
}