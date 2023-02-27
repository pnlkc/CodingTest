class Solution {
    var result = -1
    var sum = 0L
    var queue12 = intArrayOf()
    var isEnd = false
    var sumQueue1 = 0L
    var start = 0
    var end = 0

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        queue12 = queue1 + queue2
        sumQueue1 = queue1.sumOf { it.toLong() }
        val sumQueue2 = queue2.sumOf { it.toLong() }
        sum = sumQueue1 + sumQueue2
        end = queue1.lastIndex
        val maxNum = (queue1 + queue2).maxOrNull()!!
        when {
            sum % 2 != 0L -> result = -1
            sum - maxNum < maxNum -> result = -1
            else -> while (!isEnd) calc()
        }
        return result
    }

    fun calc() {
        when {
            sumQueue1 * 2 == sum -> {
                val move = start + end - queue12.lastIndex / 2
                if (result < 0 || result > move) result = move
                isEnd = true
            }
            sumQueue1 * 2 > sum -> {
                if (start + 1 < queue12.lastIndex) {
                    sumQueue1 -= queue12[start]
                    start++
                } else {
                    isEnd = true
                }
            }
            else -> {
                if (end + 1 < queue12.lastIndex) {
                    sumQueue1 += queue12[end + 1]
                    end++
                } else {
                    isEnd = true
                }
            }
        }
    }
}