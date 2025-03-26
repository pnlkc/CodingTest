var min = Int.MAX_VALUE
var arr = arrayOf<IntArray>()
var cL = mutableListOf(0)
var pick = intArrayOf()

fun main() {
    val N = readln().toInt()
    arr = Array(N + 1) { IntArray(N + 1) }
    cL.addAll(readln().split(" ").map { it.toInt() })
    pick = IntArray(N)

    for (i in 1..N) {
        val p = readln().toInt()

        for (j in 1..p) {
            val (a, d) = readln().split(" ").map { it.toInt() }

            arr[i][a] = d
        }
    }

    calc(0, 0, N)
    println(min)
}

fun calc(cnt: Int, cost: Int, n: Int) {
    if (min <= cost) return

    if (cnt == n) {
        min = minOf(min, cost)
        return
    }

    for (i in 1..n) {
        if (pick.contains(i)) continue

        pick[cnt] = i
        (1..n).forEach { cL[it] -= arr[i][it] }

        calc(cnt + 1, cost + maxOf(1, cL[i]), n)

        pick[cnt] = 0
        (1..n).forEach { cL[it] += arr[i][it] }
    }
}