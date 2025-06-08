import kotlin.math.abs

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val xArr = IntArray(M)
    val yArr = IntArray(M)
    var result = 0

    for (i in 0 until M) {
        val (y, x) = readln().split(" ").map { it.toInt() }

        xArr[i] = x
        yArr[i] = y
    }

    xArr.sort()
    yArr.sort()

    var xMid = xArr[M / 2]
    var yMid = yArr[M / 2]

    for (i in 0 until M) {
        result += abs(yMid - yArr[i])
        result += abs(xMid - xArr[i])
    }

    println(result)
}