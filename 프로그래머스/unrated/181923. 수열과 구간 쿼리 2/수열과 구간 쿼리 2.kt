class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size)

        queries.forEachIndexed { idx, query ->
            val (s, e, k) = query
            answer[idx] = arr.slice(s..e).filter { it > k }.minOrNull() ?: -1
        }

        return answer
    }
}