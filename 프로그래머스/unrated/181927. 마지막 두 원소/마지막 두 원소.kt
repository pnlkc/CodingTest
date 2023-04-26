class Solution {
    fun solution(num_list: IntArray): IntArray {
        return num_list + if (num_list.last() - num_list[num_list.lastIndex - 1] > 0) {
            num_list.last() - num_list[num_list.lastIndex - 1]
        } else {
            num_list.last() * 2
        }
    }
}