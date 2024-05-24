class Solution {
    fun solution(arr: Array<IntArray>): Int {
        var answer = 1
        
        for (i in arr.indices) {
            for (j in arr[0].indices) {
                if (i == j) continue
                
                if (arr[i][j] != arr[j][i]) {
                    answer = 0
                    break
                }
            }
        }
        
        return answer
    }
}