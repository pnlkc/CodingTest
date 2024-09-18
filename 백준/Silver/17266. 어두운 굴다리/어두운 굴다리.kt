fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var min = 100_000

    var s = 0
    var e = 100_000

    while (s <= e) {
        val mid = (s + e) / 2
        val arr = BooleanArray(N)

        for (i in list) {
            for (j in maxOf(0, i - mid) until minOf(N, i + mid)) {
                arr[j] = true
            }
        }

        if (arr.contains(false)) {
            s = mid + 1
        } else {
            min = minOf(min, mid)
            e = mid - 1
        }
    }

    println(min)
}