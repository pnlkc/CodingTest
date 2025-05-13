fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    var arr = readln().split(" ").map { it.toInt() }

    arr = arr + arr

    var max = 0
    var sum = 0

    for (i in 0 until K) {
        sum += arr[i]
    }

    max = sum

    for (i in 1 until N) {
        sum += arr[i + K - 1] - arr[i - 1]
        max = maxOf(max, sum)
    }

    println(max)
}