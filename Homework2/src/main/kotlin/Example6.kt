import java.util.Scanner

fun main(){
    var input = Scanner(System.`in`)

    print("Enter day: ")
    var day: Int = input.nextInt()

    if(calculateTheSalary(day) == -1){
        println("Day can not be smaller than 0")
    } else{
        println(calculateTheSalary(day))
    }
}

private fun calculateTheSalary(day: Int): Int{
    var maxWorkDay = 20
    var maxWorkHour = 8
    var hourlyPay = 10
    var overtimePay = 20
    if (day >= 0){
        if (day > maxWorkDay){
            return (day - maxWorkDay)*overtimePay*maxWorkHour + maxWorkDay*hourlyPay*maxWorkHour
        }

        return day*hourlyPay*maxWorkHour
    }

    return -1
}