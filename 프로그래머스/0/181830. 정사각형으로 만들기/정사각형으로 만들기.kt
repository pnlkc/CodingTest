class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        val max = maxOf(arr.size, arr[0].size)
        val answer = Array(max) { IntArray(max) }
        
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                answer[i][j] = arr[i][j]
            }
        }        
        
        return answer
    }
}