package com.helloworldstudios.yemekgetir.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.helloworldstudios.yemekgetir.R
import com.helloworldstudios.yemekgetir.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.loginFragmentObject = this

        auth = Firebase.auth
        firestore = Firebase.firestore

        binding.tvNewAccountFromLoginFragment.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_newAccountFragment)
        }

        binding.tvForgotPasswordFromLoginFragment.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        if (auth.currentUser != null){
            //Animation
            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_successfullyLoginSplashFragment)
        }
    }

    fun login(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    val currentUser = auth.currentUser
                    if (currentUser!!.isEmailVerified){
                        //Animation
                        Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_successfullyLoginSplashFragment)
                    } else{
                        Snackbar.make(requireView(), "You must verify your registration", Snackbar.LENGTH_LONG).setAction("Go to email app"){
                            val emailIntent = Intent(Intent.ACTION_MAIN);
                            emailIntent.addCategory(Intent.CATEGORY_APP_EMAIL);
                            startActivity(emailIntent)
                        }.show()
                    }
                } else{
                    Toast.makeText(requireActivity(), "Authentication failed", Toast.LENGTH_LONG).show()
                }
            }
    }
}