class Solution {
    fun solution(num_list: IntArray): Int {
        return if (num_list.size < 11) num_list.fold(1) { acc, i -> acc * i } else num_list.sum()
    }
}