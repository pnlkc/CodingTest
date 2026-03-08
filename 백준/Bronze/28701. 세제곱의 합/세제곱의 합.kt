fun main() {
    val N = readln().toInt()
    var sum1 = 0
    var sum2 = 0

    for (i in 1..N) {
        sum1 += i
        sum2 += i * i * i
    }

    println("$sum1\n${sum1 * sum1}\n$sum2")
}