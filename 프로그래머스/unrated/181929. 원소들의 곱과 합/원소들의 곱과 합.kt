class Solution {
    fun solution(num_list: IntArray): Int {
        return if (num_list.fold(1) { acc, i -> acc * i } < (num_list.sum() * num_list.sum())) 1 else 0
    }
}