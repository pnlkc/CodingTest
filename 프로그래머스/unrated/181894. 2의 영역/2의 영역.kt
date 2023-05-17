class Solution {
    fun solution(arr: IntArray): IntArray {
        return if (arr.contains(2)) {
            arr.sliceArray(arr.indexOfFirst { it == 2 }..arr.indexOfLast { it == 2 })
        } else {
            intArrayOf(-1)
        }
    }
}