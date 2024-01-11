fun main() {
    val N = readln().toInt()
    val arr = LongArray(N + 1) { 0L }

    arr[1] = 1L

    for (i in 1..N) {
        arr[i] = maxOf(arr[i], arr[i - 1] + 1)

        if (i >= 3) {
            for (j in 3 until i) {
                arr[i] = maxOf(arr[i], arr[i - j] * (j - 1))
            }
        }
    }

    println(arr[N])
}