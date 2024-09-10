import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    var result = 0L
    var num = 1

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    arr.sort()

    for (n in arr) {
        result += abs(n - num++)
    }

    println(result)
}