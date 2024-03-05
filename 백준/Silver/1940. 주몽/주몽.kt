fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val cnt = IntArray(100_001)
    var result = 0

    list.forEach { cnt[it]++ }

    for (i in cnt.indices) {
        result += minOf(cnt[i], if (M - i in 0..100_000) cnt[M - i] else 0)
    }

    println(result / 2)
}