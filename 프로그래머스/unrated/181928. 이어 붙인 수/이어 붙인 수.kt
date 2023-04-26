class Solution {
    fun solution(num_list: IntArray): Int {
        var odd = ""
        var even = ""
        num_list.forEach { if (it % 2 == 0) even += it.toString() else odd += it.toString() }
        return odd.toInt() + even.toInt()
    }
}