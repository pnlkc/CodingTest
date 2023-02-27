import java.util.Stack

class Solution {
    fun solution(scores: Array<IntArray>): Int {
        var answer = 1
        val target = scores[0].sum()

        for (i in scores.indices) {
            if (scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) return -1
        }

        val filter = scores.filter { it.sum() > target }.sortedBy { it.sum() }
        val stack = Stack<Int>()

        p@for (i in filter.indices) {
            for (j in i + 1..filter.lastIndex) {
                if (filter[j][0] > filter[i][0] && filter[j][1] > filter[i][1]) continue@p
            }
            stack.add(filter[i].sum())
        }

        while (stack.isNotEmpty()) {
            if (stack.pop() == target) break else answer++
        }

        return answer
    }
}