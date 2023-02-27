class Solution {
    var r = intArrayOf()

    fun solution(beginning: Array<IntArray>, target: Array<IntArray>): Int {
        r = intArrayOf(beginning[0].size, beginning.size)
        val result = arrayOf(
            xFirst(beginning.map { it.clone() }, target),
            xFlip(beginning.map { it.clone() }, target),
            yFirst(beginning.map { it.clone() }, target),
            yFlip(beginning.map { it.clone() }, target)
        ).filter { it > -1 }

        return if (result.minOrNull() == null) -1 else result.minOrNull()!!
    }

    fun xFirst(beginning: List<IntArray>, target: Array<IntArray>): Int {
        val xR = checkX(beginning, target)
        val yR = checkY(xR.second, target)
        return if (checkR(yR.second, target)) xR.first + yR.first else -1
    }

    fun xFlip(beginning: List<IntArray>, target: Array<IntArray>): Int {
        for (i in 0 until r[0]) beginning[0][i] = if (beginning[0][i] == 0) 1 else 0
        val xR = checkX(beginning, target)
        val yR = checkY(xR.second, target)
        return if (checkR(yR.second, target)) 1 + xR.first + yR.first else -1
    }

    fun yFirst(beginning: List<IntArray>, target: Array<IntArray>): Int {
        val yR = checkY(beginning, target)
        val xR = checkX(yR.second, target)
        return if (checkR(xR.second, target)) xR.first + yR.first else -1
    }

    fun yFlip(beginning: List<IntArray>, target: Array<IntArray>): Int {
        for (i in 0 until r[1]) beginning[i][0] = if (beginning[i][0] == 0) 1 else 0
        val yR = checkY(beginning, target)
        val xR = checkX(yR.second, target)
        return if (checkR(xR.second, target)) 1 + xR.first + yR.first else -1
    }

    fun checkX(beginning: List<IntArray>, target: Array<IntArray>): Pair<Int, List<IntArray>> {
        var result = 0
        for (i in 0 until r[0]) {
            if (beginning[0][i] == target[0][i]) continue
            result++
            for (j in 0 until r[1]) {
                beginning[j][i] = if (beginning[j][i] == 0) 1 else 0
            }
        }
        return result to beginning
    }

    fun checkY(beginning: List<IntArray>, target: Array<IntArray>): Pair<Int, List<IntArray>> {
        var result = 0
        for (i in 0 until r[1]) {
            if (beginning[i][0] == target[i][0]) continue
            result++
            for (j in 0 until r[0]) {
                beginning[i][j] = if (beginning[i][j] == 0) 1 else 0
            }
        }
        return result to beginning
    }

    fun checkR(beginning: List<IntArray>, target: Array<IntArray>): Boolean {
        var result = true
        for (i in 0 until r[1]) {
            for (j in 0 until r[0]) {
                if (beginning[i][j] != target[i][j]) {
                    result = false
                    break
                }
            }
        }
        return result
    }
}