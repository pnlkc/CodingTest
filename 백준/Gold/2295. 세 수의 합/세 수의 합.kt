fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    var r = 0
    val map = mutableMapOf<Int, Boolean>()

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    arr.sort()

    for (i in 0 until N) {
        for (j in 0 until N) {
            map[arr[i] + arr[j]] = true
        }
    }

    for (i in N - 1 downTo 0) {
        for (j in i - 1 downTo 0) {
            if (map[arr[i] - arr[j]] != null) r = maxOf(r, arr[i])
        }
    }

    println(r)
}