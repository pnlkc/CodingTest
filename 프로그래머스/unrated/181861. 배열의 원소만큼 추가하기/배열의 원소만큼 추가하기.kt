class Solution {
    fun solution(arr: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        arr.forEach { n -> repeat(n) { answer.add(n) } }
        return answer.toIntArray()
    }
}