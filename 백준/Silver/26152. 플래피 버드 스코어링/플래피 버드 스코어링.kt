fun main() {
    val sb = StringBuilder()
    val N = readln().toInt()
    val tL = readln().split(" ").map { it.toInt() }
    val lL = readln().split(" ").map { it.toInt() }
    val arr = IntArray(N)

    arr[0] = tL[0] - lL[0]

    for (i in 1 until N) {
        val h = tL[i] - lL[i]

        arr[i] = minOf(arr[i - 1], h)
    }

    val Q = readln().toInt()
    val qL = readln().split(" ").map { it.toInt() }

    for (q in 0 until Q) {
        var s = 0
        var e = N - 1
        var max = 0

        while (s <= e) {
            val mid = (s + e) / 2

            if (arr[mid] >= qL[q]) {
                s = mid + 1
                max = maxOf(max, mid)
            } else {
                e = mid - 1
            }
        }
        
        

        sb.appendLine(if (max == 0 && arr[0] < qL[q]) 0 else max + 1)
    }

    print(sb)
}