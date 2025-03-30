fun main() {
    val (N, K, B) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(B)

    for (i in 0 until B) {
        arr[i] = readln().toInt()
    }

    arr.sort()

    var s = 0
    var e = 0
    var cnt = 0
    var result = Int.MAX_VALUE

    for (i in 1..N - K + 1) {
        if (i == 1) {
            for (j in 1..K) {
                if (e < B && arr[e] == j) {
                    cnt++
                    e++
                }
            }
        } else {
            if (e < B && arr[e] == i + K - 1) {
                cnt++
                e++
            }

            if (i - 1 == arr[s]) {
                cnt--
                s++
            }
        }

        result = minOf(result, cnt)
    }

    println(result)
}