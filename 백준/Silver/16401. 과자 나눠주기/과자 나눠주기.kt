fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var result = 0

    var s = 1
    var e = list.last()

    while (s <= e) {
        val mid = (s + e) / 2
        var cnt = 0

        for (i in 0 until M) {
            cnt += list[i] / mid

            if (cnt >= N) break
        }

        if (cnt >= N) {
            result = maxOf(result, mid)
            s = mid + 1
        } else {
            e = mid - 1
        }
    }

    println(result)
}