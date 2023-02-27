class Solution {
    fun solution(a: IntArray, b: IntArray): Int 
        = a.foldIndexed(0) { idx, sum, num ->  sum + (num * b[idx]) }
}