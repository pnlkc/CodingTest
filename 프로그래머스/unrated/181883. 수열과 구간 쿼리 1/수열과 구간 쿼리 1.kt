class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { (s, e) -> (s..e).forEach { idx -> arr[idx]++ } }
        return arr
    }
}