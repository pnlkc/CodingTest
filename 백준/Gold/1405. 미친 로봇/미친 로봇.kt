import java.math.BigDecimal

var N = 0
var pList = intArrayOf()
val isVisit = Array(29) { BooleanArray(29) }
val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)
var result = 0.0

fun main() {
    val (n, ep, wp, sp, np) = readln().split(" ").map { it.toInt() }

    N = n
    pList = intArrayOf(ep, wp, sp, np)
    isVisit[14][14] = true
    calc(14, 14, 0, 1.0)

    println(BigDecimal(result).stripTrailingZeros().toPlainString())
}

fun calc(x: Int, y: Int, idx: Int, p: Double) {
    if (idx == N) {
        result += p
        return
    }

    for (d in 0 until 4) {
        val nx = x + dx[d]
        val ny = y + dy[d]

        if (!isVisit[ny][nx]) {
            isVisit[ny][nx] = true
            calc(nx, ny, idx + 1, p * pList[d] / 100)
            isVisit[ny][nx] = false
        }
    }
}