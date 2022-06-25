import java.util.Scanner

fun main(){
    var input = Scanner(System.`in`)

    print("Enter long edge: ")
    var longEdge: Double = input.nextDouble()

    print("Enter short edge: ")
    var shortEdge: Double = input.nextDouble()

    println(calculateThePerimeter(longEdge, shortEdge))
}

private fun calculateThePerimeter(longEdge: Double, shortEdge: Double): Double{
    return longEdge*2 + shortEdge*2
}