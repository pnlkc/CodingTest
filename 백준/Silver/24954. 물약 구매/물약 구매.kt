var min = Int.MAX_VALUE
var arr = arrayOf<IntArray>()

fun main() {
    val N = readln().toInt()
    val cL = listOf(0) + readln().split(" ").map { it.toInt() }
    arr = Array(N + 1) { IntArray(N + 1) }


    for (i in 1..N) {
        val p = readln().toInt()

        for (j in 1..p) {
            val (a, d) = readln().split(" ").map { it.toInt() }

            arr[i][a] = d
        }
    }

    calc(mutableListOf(), 0, N, cL.toMutableList())
    println(min)
}

fun calc(pL: MutableList<Int>, cost:Int, n: Int, cL: MutableList<Int>) {
    if (min <= cost) return

    if (pL.size == n) {
        min = minOf(min, cost)
        return
    }

    for (i in 1..n) {
        if (pL.contains(i)) continue
        val tempPL = pL.toMutableList()
        val tempCL = cL.toMutableList()

        tempPL.add(i)

        for (j in 1..n) {
            tempCL[j] -= arr[i][j]
            if (tempCL[j] <= 0) tempCL[j] = 1
        }

        calc(tempPL, cost + cL[i], n, tempCL)
    }
}