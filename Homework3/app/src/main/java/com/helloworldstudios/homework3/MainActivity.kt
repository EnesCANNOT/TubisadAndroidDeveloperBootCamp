package com.helloworldstudios.homework3

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.helloworldstudios.homework3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var amount: Int = 1
    private var productPrice: Int = 0

    private lateinit var chip: Chip



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productPrice = resources.getString(R.string.productPrice).toInt()

        if(productPrice == 3){
            binding.productPrice.text = "3 $"
        } else if (productPrice == 60){
            binding.productPrice.text = "60 ₺"
        } else{
            println("Something went wrong!")
        }
    }

    fun increaseAmount(view: View){
        amount = binding.productAmount.text.toString().toInt()
        amount++
        binding.productAmount.text = amount.toString()

        if (productPrice == 3){
            binding.productPrice.text = ((amount*productPrice).toString() + " $")
        } else if (productPrice == 60){
            binding.productPrice.text = ((amount*productPrice).toString() + " ₺")
        } else{
            println("Something went wrong!")
        }

        binding.decreaseImage.isClickable = true
    }

    fun decreaseAmount(view: View){
        amount = binding.productAmount.text.toString().toInt()

        if (amount > 0){
            amount--
            binding.productAmount.text = amount.toString()

            if (productPrice == 3){
                binding.productPrice.text = ((amount*productPrice).toString() + " $")
            } else if (productPrice == 60){
                binding.productPrice.text = ((amount*productPrice).toString() + " ₺")
            } else{
                println("Something went wrong!")
            }

        } else{
            if (productPrice == 3){
                binding.productPrice.text = ((amount*productPrice).toString() + " $")
            } else if (productPrice == 60){
                binding.productPrice.text = ((amount*productPrice).toString() + " ₺")
            } else{
                println("Something went wrong!")
            }
            binding.decreaseImage.isClickable = false
        }
    }

    fun addToCart(view: View){
        amount = binding.productAmount.text.toString().toInt()

        if (amount > 1){
            Toast.makeText(this, R.string.toastMessageWhenButtonClickedForPlural, Toast.LENGTH_LONG).show()
        } else if (amount == 1){
            Toast.makeText(this, R.string.toastMessageWhenButtonClickedForSingular, Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this, R.string.toastMessageWhenButtonClickedForNull, Toast.LENGTH_LONG).show()
        }
    }

    fun chip1(view: View){
        if (binding.chip1.chipBackgroundColor == ColorStateList.valueOf(resources.getColor(R.color.mainColor))){
            binding.chip1.chipBackgroundColor = ColorStateList.valueOf(Color.GRAY)
        } else{
            binding.chip1.chipBackgroundColor = ColorStateList.valueOf(resources.getColor(R.color.mainColor))
        }
    }

    fun chip2(view: View){
        if (binding.chip2.chipBackgroundColor == ColorStateList.valueOf(resources.getColor(R.color.mainColor))){
            binding.chip2.chipBackgroundColor = ColorStateList.valueOf(Color.GRAY)
        } else{
            binding.chip2.chipBackgroundColor = ColorStateList.valueOf(resources.getColor(R.color.mainColor))
        }
    }

    fun chip3(view: View){
        if (binding.chip3.chipBackgroundColor == ColorStateList.valueOf(resources.getColor(R.color.mainColor))){
            binding.chip3.chipBackgroundColor = ColorStateList.valueOf(Color.GRAY)
        } else{
            binding.chip3.chipBackgroundColor = ColorStateList.valueOf(resources.getColor(R.color.mainColor))
        }
    }

    fun chip4(view: View){
        if (binding.chip4.chipBackgroundColor == ColorStateList.valueOf(resources.getColor(R.color.mainColor))){
            binding.chip4.chipBackgroundColor = ColorStateList.valueOf(Color.GRAY)
        } else{
            binding.chip4.chipBackgroundColor = ColorStateList.valueOf(resources.getColor(R.color.mainColor))
        }
    }
}