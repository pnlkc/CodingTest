fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var sum = 0L
    var result = 0L

    for (i in 0 until m) {
        sum += list[i]
    }

    result = sum

    for (i in m until n) {
        sum += list[i] - list[i - m]
        result = maxOf(result, sum)
    }

    println(result)
}