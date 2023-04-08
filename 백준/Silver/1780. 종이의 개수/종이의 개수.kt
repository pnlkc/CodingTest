fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln().split(" ").map { it.toInt() } }
    val r = intArrayOf(0, 0, 0)
    calc(arr, n, 0, 0, r)
    println(r.joinToString("\n"))
}

fun calc(arr: Array<List<Int>>, n: Int, x: Int, y: Int, r: IntArray) {
    val exist = mutableMapOf(-1 to false, 0 to false, 1 to false)

    for (i in x until x + n) {
        for (j in y until y + n) {
            when (arr[i][j]) {
                -1 -> exist[-1] = true
                0 -> exist[0] = true
                1 -> exist[1] = true
            }
            if (exist.values.count { it } >= 2) break
        }
    }

    if (exist.values.count { it } == 1) {
        if (exist[-1]!!) r[0]++ else if (exist[0]!!) r[1]++ else r[2]++
    } else {
        val xL = arrayOf(x, x + n / 3, x + n / 3 + n / 3)
        val yL = arrayOf(y, y + n / 3, y + n / 3 + n / 3)

        for (i in xL.indices) {
            for (j in yL.indices) {
                calc(arr, n / 3, xL[i], yL[j], r)
            }
        }
    }
}