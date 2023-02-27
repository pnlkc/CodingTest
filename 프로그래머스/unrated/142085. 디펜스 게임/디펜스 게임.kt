import java.util.PriorityQueue
class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var leftNum = n
        val priorityQueue = PriorityQueue<Int>()
        for (i in enemy.indices) {
            priorityQueue.add(enemy[i])
            if (i >= k) {
                leftNum -= priorityQueue.poll()!!
                if (leftNum < 0) return i
            }
        }
        return enemy.size
    }
}