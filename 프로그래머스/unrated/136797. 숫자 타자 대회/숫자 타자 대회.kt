class Solution {
    val btn = mutableMapOf<Char, IntArray>()
    val dist = Array(10) { IntArray(10) { 0 } }

    fun solution(numbers: String): Int {
        makeBtn()
        makeDist()
        var mapOne = mutableMapOf("4 6" to 0)
        val mapTwo = mutableMapOf<String, Int>()
        var list = listOf("4 6")
        dist.forEach { println(it.toList()) }

        for (n in numbers) {
            for (c in list) {
                val (f, s) = c.split(" ").map { it.toInt() }

                if (n.toString().toInt() != s) {
                    val fd = dist[f][n.toString().toInt()]
                    if (mapTwo["$n $s"] == null) {
                        mapTwo["$n $s"] = mapOne[c]!! + fd
                    } else if (mapTwo["$n $s"]!! > mapOne[c]!! + fd) {
                        mapTwo["$n $s"] = mapOne[c]!! + fd
                    }
                }

                if (n.toString().toInt() != f) {
                    val sd = dist[s][n.toString().toInt()]
                    if (mapTwo["$f $n"] == null) {
                        mapTwo["$f $n"] = mapOne[c]!! + sd
                    } else if (mapTwo["$f $n"]!! > mapOne[c]!! + sd) {
                        mapTwo["$f $n"] = mapOne[c]!! + sd
                    }
                }
            }
            mapOne = mapTwo.toMutableMap()
            list = mapTwo.keys.toList()
            mapTwo.clear()
        }
        return mapOne.values.minOrNull()!!
    }

    fun makeBtn(): MutableMap<Char, IntArray> {
        btn['0'] = intArrayOf(3, 1)
        btn['1'] = intArrayOf(0, 0)
        btn['2'] = intArrayOf(0, 1)
        btn['3'] = intArrayOf(0, 2)
        btn['4'] = intArrayOf(1, 0)
        btn['5'] = intArrayOf(1, 1)
        btn['6'] = intArrayOf(1, 2)
        btn['7'] = intArrayOf(2, 0)
        btn['8'] = intArrayOf(2, 1)
        btn['9'] = intArrayOf(2, 2)
        return btn
    }

    fun makeDist() {
        for (i in '0'..'9') {
            for (j in '0'..'9') {
                val btnI = btn[i]!!
                val btnJ = btn[j]!!

                var diff = intArrayOf(btnI[0] - btnJ[0], btnI[1] - btnJ[1])
                if (diff[0] < 0) diff[0] *= -1
                if (diff[1] < 0) diff[1] *= -1
                val min = minOf(diff[0], diff[1])
                diff = intArrayOf(diff[0] - min, diff[1] - min, min)

                dist[i.toString().toInt()][j.toString().toInt()] =
                    if (diff[0] == 0 && diff[1] == 0 && diff[2] == 0) {
                        1
                    } else {
                        diff[0] * 2 + diff[1] * 2 + diff[2] * 3
                    }
            }
        }
    }
}