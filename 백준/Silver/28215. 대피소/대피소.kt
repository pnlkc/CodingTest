import kotlin.math.abs

data class Pos(val x: Int, val y: Int)

var n = 0
var k = 0
var arr = arrayOf<Pos>()
val pick = arrayOf(Pos(-1, -1), Pos(-1, -1), Pos(-1, -1))
var result = Int.MAX_VALUE

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }

    n = N
    k = K
    arr = Array(n) { Pos(-1, -1) }

    for (i in 0 until n) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        arr[i] = Pos(x, y)
    }

    pick()
    println(result)
}

fun pick() {
    when (k) {
        1 -> {
            for (i in 0 until n) {
                pick[0] = arr[i]
                calc()
            }
        }
        2 -> {
            for (i in 0 until n - 1) {
                for (j in i + 1 until n) {
                    pick[0] = arr[i]
                    pick[1] = arr[j]
                    calc()
                }
            }
        }
        3 -> {
            for (i in 0 until n - 2) {
                for (j in i + 1 until n - 1) {
                    for (k in j + 1 until n) {
                        pick[0] = arr[i]
                        pick[1] = arr[j]
                        pick[2] = arr[k]
                        calc()
                    }
                }
            }
        }
    }
}

fun calc() {
    var max = 0

    for (i in 0 until n) {
        var min = Int.MAX_VALUE

        for (j in 0 until k) {
            min = minOf(min, abs(arr[i].x - pick[j].x) + abs(arr[i].y - pick[j].y))
        }

        max = maxOf(max, min)
    }

    result = minOf(result, max)
}