fun main() {
    val (n, b) = readln().split(" ").map { it.toLong() }
    var sum = 1L
    var num = 1L

    for (i in 1..b) {
        num *= 2
        sum += num
    }

    println(if (n <= sum) "yes" else "no")
}