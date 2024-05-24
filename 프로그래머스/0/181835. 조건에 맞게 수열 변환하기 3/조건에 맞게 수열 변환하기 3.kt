class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        return arr
            .map { 
                if (k % 2 != 0) it * k else it + k 
            }
            .toIntArray()
    }
}