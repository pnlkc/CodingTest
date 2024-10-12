fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    var ans = 0
    val map = mutableMapOf<Int, Boolean>()
    val r = 0 until N

    for (i in r) {
        arr[i] = readln().toInt()

        for (j in i downTo 0) {
            map[arr[i] + arr[j]] = true
        }
    }

    for (i in r) {
        for (j in r) {
            if (map[arr[i] - arr[j]] != null) ans = maxOf(ans, arr[i])
        }
    }

    println(ans)
}