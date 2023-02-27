import java.util.LinkedList

class Solution {
    val answer = mutableListOf<Int>()
    var aMaps = listOf<CharArray>()

    fun solution(maps: Array<String>): IntArray {
        aMaps = maps.map { it.toCharArray() }

        while (aMaps.count { a -> a.count { it != 'X' } != 0 } != 0) {
            val queue = LinkedList<IntArray>()
            p@for (i in aMaps.indices) {
                for (j in aMaps[0].indices) {
                    if (aMaps[i][j] != 'X') {
                        queue.add(intArrayOf(i, j))
                        break@p
                    }
                }
            }

            calc(queue)
        }

        return if (answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }

    fun calc(queue: LinkedList<IntArray>) {
        var n = 0

        while (queue.isNotEmpty()) {
            val c = queue.pop()!!
            if (aMaps[c[0]][c[1]] == 'X') continue
            n += aMaps[c[0]][c[1]].toString().toInt()
            aMaps[c[0]][c[1]] = 'X'

            val a = intArrayOf(-1, 1, 0, 0)
            val b = intArrayOf(0, 0, -1, 1)
            
            for (i in a.indices) {
                if (c[0] + a[i] in aMaps.indices && c[1] + b[i] in aMaps[0].indices) {
                    if (aMaps[c[0] + a[i]][c[1] + b[i]] != 'X') {
                        queue.add(intArrayOf(c[0] + a[i], c[1] + b[i]))
                    }
                }
            }
        }

        answer.add(n)
    }
}