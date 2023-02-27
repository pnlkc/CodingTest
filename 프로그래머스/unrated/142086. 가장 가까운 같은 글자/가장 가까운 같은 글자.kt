class Solution {
    fun solution(s: String): IntArray {
        val answer = IntArray(s.length) { -1 }
        val distinct = mutableMapOf<Char, Int>()
        s.toList().distinct().forEach { distinct[it] = -1 }
        s.forEachIndexed { i, c ->
            if (distinct[c]!! >= 0) answer[i] = i - distinct[c]!!
            distinct[c] = i
        }
        return answer
    }
}