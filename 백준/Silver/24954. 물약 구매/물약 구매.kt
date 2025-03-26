var min = Int.MAX_VALUE
var cL = listOf<Int>()
var arr = arrayOf<IntArray>()

fun main() {
    val N = readln().toInt()
    cL = listOf(0) + readln().split(" ").map { it.toInt() }
    arr = Array(N + 1) { IntArray(N + 1) }


    for (i in 1..N) {
        val p = readln().toInt()

        for (j in 1..p) {
            val (a, d) = readln().split(" ").map { it.toInt() }

            arr[i][a] = d
        }
    }

    calc(mutableListOf(), N)
    println(min)
}

fun calc(pL: MutableList<Int>, n: Int) {
    if (pL.size == n) {
        val temp = cL.toMutableList()
        var result = 0

        for (i in 0 until n) {
            result += temp[pL[i]]

            for (j in 1..n) {
                temp[j] -= arr[pL[i]][j]
                if (temp[j] <= 0) temp[j] = 1
            }
        }

        min = minOf(min, result)
        return
    }

    for (i in 1..n) {
        if (pL.contains(i)) continue
        val temp = pL.toMutableList()
        temp.add(i)
        calc(temp, n)
    }
}