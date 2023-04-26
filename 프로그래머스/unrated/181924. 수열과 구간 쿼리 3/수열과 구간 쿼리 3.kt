class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { query ->
            val temp = arr[query[0]]
            arr[query[0]] = arr[query[1]]
            arr[query[1]] = temp
        }
        return arr
    }
}