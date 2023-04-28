class Solution {
    fun solution(n: Int): IntArray {
        val answer = mutableListOf(n)
        
        while (answer.last() != 1) {
            answer.add(if (answer.last() % 2 == 0) answer.last() / 2 else answer.last() * 3 + 1)
        }
        
        return answer.toIntArray()
    }
}