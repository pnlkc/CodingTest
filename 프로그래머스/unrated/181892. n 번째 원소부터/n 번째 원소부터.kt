class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        return num_list.sliceArray(n - 1..num_list.lastIndex)
    }
}