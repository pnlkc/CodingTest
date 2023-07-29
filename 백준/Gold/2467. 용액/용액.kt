import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map(String::toInt)
    var diff = Int.MAX_VALUE
    var answer = intArrayOf(-1, -1)
    var l = 0
    var r = n - 1

    while (l < n && l < r) {
        if (diff == 0) break

        if (diff > abs(arr[l] + arr[r])) {
            diff = abs(arr[l] + arr[r])
            answer = intArrayOf(arr[l], arr[r])
        }

        if (arr[l] + arr[r] < 0) l++ else r--
    }

    println("${answer[0]} ${answer[1]}")
}
