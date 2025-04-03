fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }.sorted()
    var sum = 0L
    var result = 0L
    var cnt = 0

    for (i in 0 until N) {
        sum += arr[i]
    }

    for (i in N - 1 downTo 0) {
        result += arr[i]
        cnt++
        if (result * 2 >= sum) break
    }

    println(M / (cnt + 1))
}