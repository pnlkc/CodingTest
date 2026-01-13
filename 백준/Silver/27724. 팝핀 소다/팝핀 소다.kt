fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    var max = 0
    var tN = n
    var basic = 0
    var tK = k

    while (tN > 1) {
        tN /= 2
        max++
    }

    while (tK > 1) {
        tK /= 2
        basic++
    }

    println(minOf(max, basic + m))
}