fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sortedDescending()
    var result = 0

    for (i in 0 until K) {
        result += list[i] - i
    }

    println(result)
}