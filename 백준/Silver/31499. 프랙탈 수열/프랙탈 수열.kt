fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    var num = 1L

    for (i in 1..N) {
        num *= i
        num %= M
    }

    println(num)
}