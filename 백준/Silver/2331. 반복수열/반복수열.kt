import kotlin.math.pow

fun main() {
    var (A, P) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(250_000)

    arr[A]++

    while (true) {
        var newA = 0

        A.toString().forEach {
            newA += it.digitToInt().toDouble().pow(P.toDouble()).toInt()
        }

        if (++arr[newA] > 2) break
        A = newA
    }

    println(arr.count { it == 1 })
}