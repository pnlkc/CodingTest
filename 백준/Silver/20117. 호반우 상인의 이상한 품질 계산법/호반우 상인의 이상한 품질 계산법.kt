fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var sum = 0

    for (i in 0 until N / 2) {
        sum += list[N - 1 - i] * 2
    }

    if (N % 2 != 0) sum += list[N / 2]

    println(sum)
}