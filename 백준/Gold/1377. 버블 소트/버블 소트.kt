fun main() {
    val N = readln().toInt()
    val arr = Array(N + 1) { 0L }

    for (i in 1..N) {
        arr[i] = readln().toLong() * 1_000_000 + i
    }

    arr.sort()

    var max = 0L

    for (i in N downTo 1) {
        max = maxOf(max, arr[i] % 1_000_000 - i)
    }

    println(max + 1)
}