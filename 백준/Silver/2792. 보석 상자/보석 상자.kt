fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(m)
    var result = Int.MAX_VALUE

    for (i in 0 until m) {
        arr[i] = readln().toInt()
    }

    arr.sort()

    var s = 1
    var e = 1_000_000_000

    while (s <= e) {
        val mid = (s + e) / 2
        var cnt = 0

        for (i in 0 until m) {
            cnt += arr[i] / mid
            if (arr[i] % mid != 0) cnt++
        }

        if (cnt > n) {
            s = mid + 1
        } else {
            result = minOf(result, mid)
            e = mid - 1
        }
    }

    println(result)
}