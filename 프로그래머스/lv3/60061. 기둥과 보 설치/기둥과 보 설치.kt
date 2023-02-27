class Solution {
    var wall = arrayOf<Array<BooleanArray>>()
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        val answer = mutableListOf<IntArray>()
        wall = Array(n + 1) { Array(n + 1) { booleanArrayOf(false, false) } }

        for (b in build_frame) {
            when (b[2]) {
                0 -> {
                    when (b[3]) {
                        0 -> {
                            wall[b[0]][b[1]][0] = false
                            if (!checkDelete(intArrayOf(b[0], b[1]))) wall[b[0]][b[1]][0] = true
                        }
                        1 -> if (checkZero(intArrayOf(b[0], b[1]))) wall[b[0]][b[1]][0] = true
                    }
                }
                1 -> {
                    when (b[3]) {
                        0 -> {
                            wall[b[0]][b[1]][1] = false
                            if (!checkDelete(intArrayOf(b[0], b[1]))) wall[b[0]][b[1]][1] = true
                        }
                        1 -> if (checkOne(intArrayOf(b[0], b[1]))) wall[b[0]][b[1]][1] = true
                    }
                }
            }
        }

        for (x in 0..n) {
            for (y in 0..n) {
                for (i in 0..1) {
                    if (wall[x][y][i]) answer.add(intArrayOf(x, y, i))
                }
            }
        }

        return answer.toTypedArray()
    }

    fun checkZero(b: IntArray): Boolean {
        if (b[1] == 0) return true

        if (b[1] - 1 in wall.indices) {
            if (wall[b[0]][b[1] - 1][0]) return true
        }

        if (wall[b[0]][b[1]][1]) return true

        if (b[0] - 1 in wall.indices) {
            if (wall[b[0] - 1][b[1]][1]) return true
        }

        if (wall[b[0]][b[1]][1]) return true

        return false
    }

    fun checkOne(b: IntArray): Boolean {
        if (b[1] - 1 in wall.indices) {
            if (wall[b[0]][b[1] - 1][0]) return true
            if (wall[b[0] + 1][b[1] - 1][0]) return true
        }

        if (b[0] - 1 in wall.indices && b[0] + 1 in wall.indices) {
            if (wall[b[0] - 1][b[1]][1] && wall[b[0] + 1][b[1]][1]) return true
        }
        return false
    }

    fun checkDelete(b: IntArray): Boolean {
        for (i in wall.indices) {
            for (j in wall.indices) {
                if (wall[i][j][0]) {
                    if (!checkZero(intArrayOf(i, j))) return false
                }

                if (wall[i][j][1]) {
                    if (!checkOne(intArrayOf(i, j))) return false
                }
            }
        }
        return true
    }
}