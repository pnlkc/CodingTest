fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val A = readln().split(" ").map { it.toLong() }.sorted()
    val B = readln().split(" ").map { it.toLong() }.sorted()

    var s = 0L
    var e = 1_000_000_000L * 1_000_000_000
    var result = 0L

    while (s <= e) {
        val mid = (s + e) / 2
        var cnt = 0L

        for (b in B) {
            var sIdx = 0
            var eIdx = N - 1

            while (sIdx <= eIdx) {
                val midIdx = (sIdx + eIdx) / 2
                if (b * A[midIdx] <= mid) {
                    sIdx = midIdx + 1
                } else {
                    eIdx = midIdx - 1
                }
            }

            cnt += sIdx
        }

        if (cnt >= K) {
            result = mid
            e = mid - 1
        } else {
            s = mid + 1
        }
    }

    println(result)
}
