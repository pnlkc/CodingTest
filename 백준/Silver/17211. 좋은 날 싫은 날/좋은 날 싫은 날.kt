import kotlin.math.round

fun main() {
    val (N, status) = readln().split(" ").map { it.toInt() }
    val pL = readln().split(" ").map { it.toDouble() }
    var a = if (status == 0) pL[0] else pL[2]
    var b = if (status == 0) pL[1] else pL[3]

    for (i in 1 until N) {
        var tempA = 0.0
        var tempB = 0.0

        tempA = a * pL[0] + b * pL[2]
        tempB = a * pL[1] + b * pL[3]

        a = tempA
        b = tempB
    }

    println(round(a * 1_000).toInt())
    println(round(b * 1_000).toInt())
}