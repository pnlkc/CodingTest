fun main() {
    val n = readln().toInt()
    val arr = IntArray(n)


    for (i in 0 until n) {
        val (h, m) = readln().split(":").map { it.toInt() }

        arr[i] = h * 60 + m
    }

    arr.sort()

    var idx = 0
    var cnt = 0

    while (idx < n) {
        if (idx + 2 < n && arr[idx + 2] - arr[idx] <= 20) idx += 2
        else if (idx + 1 < n && arr[idx + 1] - arr[idx] <= 20) idx++

        idx++
        cnt++
    }

    println(cnt)
}