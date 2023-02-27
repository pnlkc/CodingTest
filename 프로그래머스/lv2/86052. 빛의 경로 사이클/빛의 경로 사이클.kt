class Solution {
    fun solution(grid: Array<String>): IntArray {
        val table = grid.map { it.toCharArray() }
        val list = mutableListOf<Int>()
        val isVisit = Array(grid.size) { Array(grid[0].length) { BooleanArray(5) { false }} }
        for (i in table.indices) {
            for (j in table[0].indices) {
                val a = intArrayOf(1, 2, 3, 4)
                val x = intArrayOf(0, 0, 1, 0, -1)
                val y = intArrayOf(0, -1, 0, 1, 0)
                p@for (it in a) {
                    var pos = intArrayOf(i, j, it)
                    if (pos[0] != i || pos[1] != j) {
                        if(isVisit[pos[0]][pos[1]][pos[2]]) continue@p
                    }
                    isVisit[pos[0]][pos[1]][pos[2]] = true
                    var count = 1
                    do {
                        when (table[pos[0]][pos[1]]) {
                            'S' -> {
                                val yPos = when {
                                    pos[0] + y[pos[2]] > table.lastIndex -> 0
                                    pos[0] + y[pos[2]] < 0 -> table.lastIndex
                                    else -> pos[0] + y[pos[2]]
                                }
                                val xPos = when {
                                    pos[1] + x[pos[2]] > table[0].lastIndex -> 0
                                    pos[1] + x[pos[2]] < 0 -> table[0].lastIndex
                                    else -> pos[1] + x[pos[2]]
                                }
                                pos = intArrayOf(yPos, xPos, pos[2])
                            }
                            'L' -> {
                                val d = if (pos[2] - 1 < 1) 4 else pos[2] - 1
                                val yPos = when {
                                    pos[0] + y[d] > table.lastIndex -> 0
                                    pos[0] + y[d] < 0 -> table.lastIndex
                                    else -> pos[0] + y[d]
                                }
                                val xPos = when {
                                    pos[1] + x[d] > table[0].lastIndex -> 0
                                    pos[1] + x[d] < 0 -> table[0].lastIndex
                                    else -> pos[1] + x[d]
                                }
                                pos = intArrayOf(yPos, xPos, d)
                            }
                            'R' -> {
                                val d = if (pos[2] + 1 > 4) 1 else pos[2] + 1
                                val yPos = when {
                                    pos[0] + y[d] > table.lastIndex -> 0
                                    pos[0] + y[d] < 0 -> table.lastIndex
                                    else -> pos[0] + y[d]
                                }
                                val xPos = when {
                                    pos[1] + x[d] > table[0].lastIndex -> 0
                                    pos[1] + x[d] < 0 -> table[0].lastIndex
                                    else -> pos[1] + x[d]
                                }
                                pos = intArrayOf(yPos, xPos, d)
                            }
                        }
                        if (pos[0] != i || pos[1] != j) {
                            if(isVisit[pos[0]][pos[1]][pos[2]]) continue@p
                        }
                        isVisit[pos[0]][pos[1]][pos[2]] = true
                        count++
                    } while (pos[0] != i || pos[1] != j || pos[2] != it)
                    list.add(count - 1)
                }

            }
        }
        return list.sorted().toIntArray()
    }
}