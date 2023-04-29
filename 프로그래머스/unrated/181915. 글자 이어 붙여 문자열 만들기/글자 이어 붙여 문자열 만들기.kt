class Solution {
    fun solution(my_string: String, index_list: IntArray): String {
        var sb = StringBuilder()
        index_list.forEach { sb.append(my_string[it]) }
        return sb.toString()
    }
}