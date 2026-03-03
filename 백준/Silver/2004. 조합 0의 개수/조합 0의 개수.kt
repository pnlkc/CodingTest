fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = calc(n, 2) - calc(n - m, 2) - calc(m, 2)
    val b = calc(n, 5) - calc(n - m, 5) - calc(m, 5)

    println(minOf(a, b))
}

fun calc(num: Int, divide: Int): Int {
    var temp = num
    var cnt = 0

    while (temp > 0) {
        cnt += temp / divide
        temp /= divide
    }

    return cnt
}