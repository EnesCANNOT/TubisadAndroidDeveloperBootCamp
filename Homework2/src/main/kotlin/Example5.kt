import java.util.Scanner

fun main(){
    var input = Scanner(System.`in`)

    print("Enter number of edges: ")
    var edgeNumber: Int = input.nextInt()

    if (calculateTheSumOfInteriorAngles(edgeNumber) == -1){
        println("Edge number can not be smaller than 3")
    } else{
        println(calculateTheSumOfInteriorAngles(edgeNumber))
    }
}

private fun calculateTheSumOfInteriorAngles(edgeNumber: Int): Int{
    if (edgeNumber < 3){
        return -1
    } else{
        return (edgeNumber-2)*180
    }
}