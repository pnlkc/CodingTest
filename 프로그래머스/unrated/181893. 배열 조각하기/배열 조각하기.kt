class Solution {
    fun solution(arr: IntArray, query: IntArray): IntArray {
        var answer = arr.toList()
        query.forEachIndexed { idx, i ->
            answer = if (idx % 2 == 0) {
                answer.slice(0..i)
            } else {
                answer.slice(i..answer.lastIndex)
            }
        }
        return answer.toIntArray()
    }
}