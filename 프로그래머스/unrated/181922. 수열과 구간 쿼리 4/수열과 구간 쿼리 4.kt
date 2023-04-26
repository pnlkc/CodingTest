class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { query ->
            val (s, e, k) = query
            
            (s..e).forEach { i -> if (i % k == 0) arr[i]++ }
        }
        
        return arr
    }
}