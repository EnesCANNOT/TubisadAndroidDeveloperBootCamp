import java.util.Scanner

fun main(){
    var input = Scanner(System.`in`)

    print("Enter quota amount: ")
    var quotaAmount: Int = input.nextInt()

    if (calculateTheFee(quotaAmount) == -1){
        println("Quota can not be smaller than 0")
    } else{
        println(calculateTheFee(quotaAmount))
    }
}

fun calculateTheFee(quotaAmount: Int): Int{
    var maxQuota: Int = 50
    var excessPrice: Int = 4
    var quotaPrice: Int = 100
    if (quotaAmount >= 0){
        if (quotaAmount > maxQuota){
            return (quotaAmount-maxQuota)*excessPrice + quotaPrice
        }

        return quotaPrice
    }

    return -1
}