class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val list= mutableListOf<Int>()
        for (s in score) {
            list.add(s)
            list.sortDescending()
            if (list.size < k) answer.add(list.last()) else answer.add(list[k - 1])
        }
        return answer.toIntArray()
    }
}