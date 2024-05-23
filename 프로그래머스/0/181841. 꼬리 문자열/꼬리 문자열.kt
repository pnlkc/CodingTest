class Solution {
    fun solution(str_list: Array<String>, ex: String): String {
        return str_list.filter { !it.contains(ex) }.joinToString("")
    }
}