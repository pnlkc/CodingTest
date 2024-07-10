fun main() {
    val N = readln().toInt()
    val arr = IntArray(4)
    var cnt = 0

    for (i in 1..N) {
        var (t, b) = readln().split("/").map { it.toInt() }

        if (b == 2) {
            t *= 2
            b *= 2
        }

        arr[t]++
    }

    cnt += arr[3]
    arr[1] -= arr[3]
    arr[3] = 0

    cnt += arr[2] / 2
    arr[2] = arr[2] % 2

    if (arr[2] == 1) {
        cnt++
        arr[1] -= 2
    }

    if (arr[1] > 0) {
        cnt += arr[1] / 4
        if (arr[1] % 4 != 0) cnt++
    }

    println(cnt)
}