package com.helloworldstudios.todoapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.helloworldstudios.todoapp.R

fun Navigation.gecisYap(view: View, id: Int){
    findNavController(view).navigate(id)
}

fun Navigation.gecisYap(view: View, navDir: NavDirections){
    findNavController(view).navigate(navDir)
}