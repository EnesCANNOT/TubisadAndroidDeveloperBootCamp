import java.util.Scanner

fun main(){
    var input = Scanner(System.`in`)

    print("Enter text: ")
    var text: String = input.nextLine()

    print("Enter letter: ")
    var letter: Char = input.next().single()

    println(charCounter(text, letter))
}

private fun charCounter(text: String, letter: Char): Int{
    var counter: Int = 0

    for (c:Char in text.toCharArray()){
        if (c==letter){
            counter++
        }
    }

    return counter
}