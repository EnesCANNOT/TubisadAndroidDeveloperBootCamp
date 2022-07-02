package com.helloworldstudios.homework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.helloworldstudios.homework5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var number1: Double? = null
    private var number2: Double? = null
    private lateinit var operation: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun number0(view: View){

        if (binding.etNumberField.text.toString().isNotEmpty()){
            if (binding.etNumberField.text.toString().toDouble() != 0.0){
                println("Hi")
                binding.etNumberField.setText(binding.etNumberField.text.toString() + "0")
            } else{
//                println("Hello")
//                binding.etNumberField.setText("0")

                if(binding.etNumberField.text.toString().contains(".")){
                    binding.etNumberField.setText(binding.etNumberField.text.toString() + "0")
                }
            }
        } else{
            binding.etNumberField.setText("0")
        }
    }

    fun number00(view: View){
        if (binding.etNumberField.text.toString().toDouble() > 0.0){
            binding.etNumberField.setText(binding.etNumberField.text.toString() + "00")
        } else{
            binding.etNumberField.setText("0")
        }
    }

    fun number1(view: View){
        binding.etNumberField.setText(binding.etNumberField.text.toString() + "1")
    }

    fun number2(view: View){
        binding.etNumberField.setText(binding.etNumberField.text.toString() + "2")
    }

    fun number3(view: View){
        binding.etNumberField.setText(binding.etNumberField.text.toString() + "3")
    }

    fun number4(view: View){
        binding.etNumberField.setText(binding.etNumberField.text.toString() + "4")
    }

    fun number5(view: View){
        binding.etNumberField.setText(binding.etNumberField.text.toString() + "5")
    }

    fun number6(view: View){
        binding.etNumberField.setText(binding.etNumberField.text.toString() + "6")
    }

    fun number7(view: View){
        binding.etNumberField.setText(binding.etNumberField.text.toString() + "7")
    }

    fun number8(view: View){
        binding.etNumberField.setText(binding.etNumberField.text.toString() + "8")
    }

    fun number9(view: View){
        binding.etNumberField.setText(binding.etNumberField.text.toString() + "9")
    }

    fun numberPoint(view: View){
        if(binding.etNumberField.text.isNotEmpty()){
            if (!(binding.etNumberField.text.toString().contains("."))){
                binding.etNumberField.setText(binding.etNumberField.text.toString() + ".")
            }
        } else{
            binding.etNumberField.setText(binding.etNumberField.text.toString() + "0.")
        }
    }

    fun division(view: View){
        if (binding.etNumberField.text.toString().isNotEmpty()){
            operation = "division"
            if (number1 == null){
                number1 = binding.etNumberField.text.toString().toDouble()
                binding.etNumberField.setText("")
            } else if (number2 == null){
                if (binding.etNumberField.text.toString().toDouble() != 0.0){
                    number2 = binding.etNumberField.text.toString().toDouble()
                    binding.etNumberField.setText("")
                } else{
                    Toast.makeText(this, "2nd number cannot be 0 for division operator", Toast.LENGTH_LONG).show()
                    binding.etNumberField.setText("")
                }
            } else{
                Toast.makeText(this, "Division Method : Program crashing", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun remainder(view: View){
        if (binding.etNumberField.text.toString().isNotEmpty()){
            operation = "remainder"
            if (number1 == null){
                number1 = binding.etNumberField.text.toString().toDouble()
                binding.etNumberField.setText("")
            } else if (number2 == null){
                number2 = binding.etNumberField.text.toString().toDouble()
                binding.etNumberField.setText("")
            } else{
                Toast.makeText(this, "Remainder Method : Program crashing", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun multiplication(view: View){
        if (binding.etNumberField.text.toString().isNotEmpty()){
            operation = "multiplication"
            if (number1 == null){
                number1 = binding.etNumberField.text.toString().toDouble()
                binding.etNumberField.setText("")
            } else if (number2 == null){
                number2 = binding.etNumberField.text.toString().toDouble()
                binding.etNumberField.setText("")
            } else{
                Toast.makeText(this, "Multiplication Method : Program crashing", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun subtraction(view: View){
        if (binding.etNumberField.text.toString().isNotEmpty()){
            operation = "subtraction"
            if (number1 == null){
                number1 = binding.etNumberField.text.toString().toDouble()
                binding.etNumberField.setText("")
            } else if (number2 == null){
                number2 = binding.etNumberField.text.toString().toDouble()
                binding.etNumberField.setText("")
            } else{
                Toast.makeText(this, "Subtraction Method : Program crashing", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun addition(view: View){
        if (binding.etNumberField.text.toString().isNotEmpty()){
            operation = "addition"
            if (number1 == null){
                number1 = binding.etNumberField.text.toString().toDouble()
                binding.etNumberField.setText("")
            } else if (number2 == null){
                number2 = binding.etNumberField.text.toString().toDouble()
                binding.etNumberField.setText("")
            } else{
                Toast.makeText(this, "Addition Method : Program crashing", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun result(view: View){

        if (binding.etNumberField.text.toString().isNotEmpty()){
            number2 = binding.etNumberField.text.toString().toDouble()
        } else{
            Toast.makeText(this, "Enter 2nd number", Toast.LENGTH_LONG).show()
        }

        if(number1 != null && number2 != null){
            when(operation){

                "addition" -> {
                    binding.etNumberField.setText((number1!! + number2!!).toString())
                    number1 = null
                    number2 = null
                }

                "subtraction" -> {
                    binding.etNumberField.setText((number1!! - number2!!).toString())
                    number1 = null
                    number2 = null
                }

                "multiplication" -> {
                    binding.etNumberField.setText((number1!! * number2!!).toString())
                    number1 = null
                    number2 = null
                }

                "division" -> {
                    binding.etNumberField.setText((number1!! / number2!!).toString())
                    number1 = null
                    number2 = null
                }

                "remainder" -> {
                    binding.etNumberField.setText((number1!! % number2!!).toString())
                    number1 = null
                    number2 = null
                }

                else -> {
                    Toast.makeText(this, "Invalid operation : ${operation}", Toast.LENGTH_LONG).show()
                }
            }
        }

        else{
            Toast.makeText(this, "Numbers cannot be null. Number1 : ${number1}, Number2 : ${number2}", Toast.LENGTH_LONG).show()
        }
    }

    fun clear(view: View){
        binding.etNumberField.setText("")
        number1 = null
        number2 = null
    }
}