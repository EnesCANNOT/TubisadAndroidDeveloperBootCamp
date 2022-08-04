package com.helloworldstudios.yemekgetir

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.helloworldstudios.yemekgetir.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        binding.forgotPasswordObject = this

        auth = Firebase.auth

        return binding.root
    }

    fun newAccount(){
        Navigation.findNavController(requireView()).navigate(R.id.action_forgotPasswordFragment_to_newAccountFragment)
    }

    fun login(){
        Navigation.findNavController(requireView()).navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
    }

    fun resetPassword(email: String){
        if (checkValidEmail(email)){
            auth.sendPasswordResetEmail(email)
                .addOnSuccessListener {
                    Toast.makeText(requireActivity(), R.string.password_reset_link_sent, Toast.LENGTH_LONG).show()
                }.addOnFailureListener{
                    Log.e("ForgotPassword Fragment", it.localizedMessage.toString())
                    Toast.makeText(requireActivity(), it.localizedMessage, Toast.LENGTH_LONG).show()
                }
        }
    }

    private fun checkValidEmail(email: String) : Boolean{
        if(email.isEmpty()){
            binding.etEmailFromForgotPasswordFragment.requestFocus()
            Log.e("ForgotPassword Fragment", "Email is empty")
            Toast.makeText(requireActivity(), R.string.email_can_not_be_empty, Toast.LENGTH_LONG).show()
            return false
        } else{
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Log.e("ForgotPassword Fragment", "Email type is invalid")
                Toast.makeText(requireActivity(), R.string.invalid_email_type, Toast.LENGTH_LONG).show()
                return false
            } else{
                Log.e("ForgotPassword Fragment", "Email is okay")
                return true
            }
        }
    }
}