import kotlin.math.abs

data class Data(val x: Int, val y: Int, val s: Int)

var n = 0
var m = 0
var k = 0
var t =0
var p = 0
var mL = arrayOf<Data>()
var isVisit = booleanArrayOf()
var a = 0
var b = 0

fun main() {
    val (N, M, K, T, P) = readln().split(" ").map { it.toInt() }

    mL = Array(K) { Data(0, 0, 0) }
    n = N
    m = M
    k = K
    t = T
    p = P
    isVisit = BooleanArray(k)

    repeat (k) {
        val (r, c, s) = readln().split(" ").map { it.toInt() }

        mL[it] = Data(c, r, s)
    }

    // 우정
    for (i in 0 until k) {
        val (x, y, s) = mL[i]

        isVisit[i] = true
        check(x, y, 0, 1)
        isVisit[i] = false
    }

    // 아름
    p@ for (i in 1..n) {
        for (j in 1..m) {
            var cnt = 0

            for ((c, r ,s) in mL) {
                if (i == r && j == c) {
                    cnt++
                    continue
                }

                val power = p / (abs(i - r) + abs(j - c))

                if (s <= power) cnt++
            }

            b = maxOf(b, cnt)
        }
    }

    println("$a $b")
}

fun check(x: Int, y: Int, move: Int, cnt: Int) {
    a = maxOf(a, cnt)

    for (i in 0 until k) {
        if (isVisit[i]) continue

        val (nx, ny, ns) = mL[i]
        val nextMove = move + abs(y - ny) + abs(x - nx)

        if (nextMove > t) continue

        isVisit[i] = true
        check(nx, ny, nextMove, cnt + 1)
        isVisit[i] = false
    }
}