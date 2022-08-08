package com.helloworldstudios.yemekgetir.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.helloworldstudios.yemekgetir.MainActivity
import com.helloworldstudios.yemekgetir.R
import com.helloworldstudios.yemekgetir.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        binding.profileFragmentObject = this

        firestore = Firebase.firestore
        auth = Firebase.auth

        userInfos()

        return binding.root
    }

    fun buttonSignOut(){
        Firebase.auth.signOut()
        startActivity(Intent(requireActivity(), MainActivity::class.java))
        requireActivity().finish()
    }

    fun userInfos(){
        firestore.collection("Users")
            .whereEqualTo("email", auth.currentUser!!.email)
            .addSnapshotListener{value, error ->
                if (error != null){
                    Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_LONG).show()
                } else{
                    if (value != null){
                        if (!value.isEmpty){
                            val user = value.documents
                            for (field in user){
                                binding.tvUserFullname.text = field.get("fullName").toString()
                                binding.tvUserEmail.text = field.get("email").toString()
                                binding.tvUserPhone.text = field.get("phoneNo").toString()
                            }
                        } else{
                            println("Value is empty")
                        }
                    } else{
                        println("Value is null")
                    }
                }
            }
    }
}