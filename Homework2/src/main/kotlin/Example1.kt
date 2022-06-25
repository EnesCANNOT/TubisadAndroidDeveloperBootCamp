import java.util.Scanner

fun main(){
    var input = Scanner(System.`in`)
    print("Enter celcius: ")
    var celcius: Double = input.nextDouble()
    println(convertToFahrenheit(celcius))
}

private fun convertToFahrenheit(celcius: Double): Double{
    return celcius*1.8 + 32
}