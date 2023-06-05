class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        val answer = mutableListOf<Int>()
        val map = mutableMapOf<Int, Boolean>()

        arr.forEach { 
            if (map[it] == null && answer.size < k) {
                answer.add(it)
                map[it] = true
            } 
        }
        
        repeat(k - answer.size) { answer.add(-1) }

        return answer.toIntArray()
    }
}