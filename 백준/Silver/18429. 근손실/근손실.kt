var N = 0
var K = 0
var pick = intArrayOf()
var list = listOf<Int>()
var cnt = 0

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    N = n
    K = k
    list = readln().split(" ").map { it.toInt() }
    pick = IntArray(N)

    calc(0, 500)
    println(cnt)
}

fun calc(idx: Int, c: Int) {
    if (idx == N) {
        cnt++
        return
    }

    p@ for (i in 0 until N) {
        for (j in 0 until idx) {
            if (pick[j] == i) continue@p
        }

        if (c + list[i] - K >= 500) {
            pick[idx] = i
            calc(idx + 1, c + list[i] - K)
        }
    }
}