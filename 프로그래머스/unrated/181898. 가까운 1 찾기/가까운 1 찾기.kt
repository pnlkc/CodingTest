class Solution {
    fun solution(arr: IntArray, idx: Int): Int {
        for (i in idx..arr.lastIndex) {
            if (arr[i] == 1) return i
        }
        return -1
    }
}