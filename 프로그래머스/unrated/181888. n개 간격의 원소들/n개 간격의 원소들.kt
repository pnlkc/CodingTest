class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        return (num_list.indices step n).map { num_list[it] }.toIntArray()
    }
}