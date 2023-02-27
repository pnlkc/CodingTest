class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer = 0
        val list = tangerine.distinct().map { l -> tangerine.count { it == l } }.sortedDescending()
        var sum = 0
        for (i in list.indices) {
            sum += list[i]
            if (sum >= k) {
                answer = i + 1
                break
            }
        }
        return answer
    }
}