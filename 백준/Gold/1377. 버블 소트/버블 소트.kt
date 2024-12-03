fun main() {
    val N = readln().toInt()
    val NUM = 1_000_000
    val arr = LongArray(N + 1)

    for (i in 1..N) {
        arr[i] = readln().toLong() * NUM + i
    }

    arr.sort()

    var max = 0L

    for (i in N downTo 1) {
        max = maxOf(max, arr[i] % NUM - i)
    }

    println(max + 1)
}