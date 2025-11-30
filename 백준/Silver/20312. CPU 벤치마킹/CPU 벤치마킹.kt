fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val NUM = 1_000_000_007
    var result = 0L
    var prev = 0L

    for (i in 0 until n - 1) {
        prev = prev * list[i] + list[i]
        prev %= NUM
        result += prev
        result %= NUM
    }

    println(result)
}