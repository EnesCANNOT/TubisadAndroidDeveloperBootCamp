import java.util.Scanner

fun main(){
    var input = Scanner(System.`in`)

    print("Enter number: ")
    var number: Int = input.nextInt()

    println(calculateFactorial(number))
}

private fun calculateFactorial(number: Int): Long{

    return if (number == 1){
        number.toLong()
    } else{
        number*calculateFactorial(number-1)
    }
}