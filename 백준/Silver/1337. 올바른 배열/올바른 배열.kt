fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    var max = 1

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    arr.sort()

    var s = 0

    while (s < N) {
        var idx = s

        while (idx + 1 < N && arr[idx + 1] <= arr[s] + 4) {
            idx++
        }

        max = maxOf(max, idx - s + 1)
        s++
    }

    println(5 - max)
}