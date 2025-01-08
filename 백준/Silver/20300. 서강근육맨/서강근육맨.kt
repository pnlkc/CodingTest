fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toLong() }.sorted()
    var s = 0
    var e = N - 1
    var max = 0L

    if (N % 2 != 0) {
        --e
        max = list[N - 1]
    }

    while (s < e) {
        max = maxOf(max, list[s] + list[e])
        ++s
        --e
    }

    println(max)
}