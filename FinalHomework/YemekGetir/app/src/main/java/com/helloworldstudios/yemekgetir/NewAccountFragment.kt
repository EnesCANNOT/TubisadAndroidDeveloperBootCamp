package com.helloworldstudios.yemekgetir

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.helloworldstudios.yemekgetir.databinding.FragmentNewAccountBinding
import java.util.regex.Matcher
import java.util.regex.Pattern

class NewAccountFragment : Fragment() {

    private lateinit var binding: FragmentNewAccountBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_account, container, false)
        binding.newAccountObject = this

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
        firestore = Firebase.firestore
    }

    fun register(fullname: String, email: String, phoneNo: String, password1: String, password2: String){
        if(checkValidFullname(fullname)){
            if (checkValidEmail(email)){
                if (checkValidPhoneNo(phoneNo)){
                    if (checkPasswords(password1, password2)){
                        register(email, password1)
                    }
                }
            }
        }
    }

    private fun checkValidFullname(fullname: String): Boolean{
        if (fullname.isEmpty()){
            binding.etFullnameFromNewAccountFragment.requestFocus()
            Log.e("New Account Fragment", "Fullname is empty")
            Toast.makeText(requireActivity(), R.string.fullname_empty_from_new_acc_fragment, Toast.LENGTH_LONG).show()
            return false
        } else{
            Log.e("New Account Fragment", "Fullname is okay")
            return true
        }
    }

    private fun checkValidEmail(email: String): Boolean{
        if(email.isEmpty()){
            binding.etEmailFromNewAccountFragment.requestFocus()
            Log.e("New Account Fragment", "Email is empty")
            Toast.makeText(requireActivity(), R.string.email_can_not_be_empty, Toast.LENGTH_LONG).show()
            return false
        } else{
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Log.e("New Account Fragment", "Email not matched")
                Toast.makeText(requireActivity(), R.string.invalid_email_type, Toast.LENGTH_LONG).show()
                return false
            } else{
                Log.e("New Account Fragment", "Email is okay")
                return true
            }
        }
    }

    private fun checkValidPhoneNo(phoneNo: String): Boolean{
        if (phoneNo.isEmpty()){
            binding.etPhoneNumberFromNewAccountFragment.requestFocus()
            Log.e("New Account Fragment", "Phone Number is empty")
            Toast.makeText(requireActivity(), R.string.phone_number_is_empty, Toast.LENGTH_LONG).show()
            return false
        } else{
            var pattern : Pattern = Pattern.compile("(05|5)[0-9][0-9][1-9]([0-9]){6}")
            var matcher : Matcher = pattern.matcher(phoneNo)

            if (!matcher.matches()){
                Log.e("New Account Fragment", "Phone Number pattern is invalid")
                Toast.makeText(requireActivity(), R.string.phone_number_is_invalid, Toast.LENGTH_LONG).show()
                return false
            } else{
                Log.e("New Account Fragment", "Phone Number pattern is valid")
                return true
            }
        }
    }

    private fun checkPasswords(password1: String, password2: String): Boolean{
        if (password1.isEmpty() || password2.isEmpty()){
            if (password1.isEmpty()){
                binding.etPassword1FromNewAccountFragment.requestFocus()
                return false
            } else{
                binding.etPassword2FromNewAccountFragment.requestFocus()
                return false
            }
        } else{
            if (password1 == password2){
                val passwordLength = 6
                if (password1.length < passwordLength){
                    binding.etPassword1FromNewAccountFragment.requestFocus()
                    binding.etPassword2FromNewAccountFragment.requestFocus()
                    Log.e("New Account Fragment", "Passwords length is smaller than $passwordLength")
                    Toast.makeText(requireActivity(), (R.string.password_length_can_not_be_smaller_than_passwordLength + passwordLength), Toast.LENGTH_LONG).show()
                    return false
                } else{
                    return true
                }
            } else{
                Toast.makeText(requireActivity(), R.string.password_not_matched, Toast.LENGTH_LONG).show()
                return false
            }
        }
    }

    private fun register(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(){
            if (it.isSuccessful){
                saveUserFieldsToStorage(binding.etFullnameFromNewAccountFragment.text.toString(), email, binding.etPhoneNumberFromNewAccountFragment.text.toString(), password)
                val currentUser = auth.currentUser
                currentUser!!.sendEmailVerification()
                    .addOnCompleteListener(){
                        if (it.isSuccessful){

                            if (!auth.currentUser!!.isEmailVerified){
                                auth.signOut()
                                findNavController().popBackStack()
                            }

                            Snackbar.make(requireView(), "Verification email send to ${currentUser.email}", Snackbar.LENGTH_INDEFINITE).setAction("Go to email app"){
                                val emailIntent = Intent(Intent.ACTION_MAIN);
                                emailIntent.addCategory(Intent.CATEGORY_APP_EMAIL);
                                startActivity(emailIntent)
                            }.show()
                        }
                    }

            }
        }
    }

    private fun saveUserFieldsToStorage(fullName: String, email: String, phoneNo: String, password: String){

        val userMap = hashMapOf<String, Any>()

        userMap.put("fullName", fullName)
        userMap.put("email", email)
        userMap.put("phoneNo", phoneNo)
        userMap.put("password", password)

        firestore.collection("Users").document(email).set(userMap).addOnSuccessListener {
            println("")
            Log.e("New Account Fragment", "User informations successfully saved")

        }.addOnFailureListener {
            Log.e("New Account Fragment", "User informations could not be saved")
            Toast.makeText(requireActivity(), it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
}