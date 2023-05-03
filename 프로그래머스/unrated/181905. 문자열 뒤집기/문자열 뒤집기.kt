class Solution {
    fun solution(my_string: String, s: Int, e: Int): String {
        return my_string.replaceRange(s..e, my_string.slice(s..e).reversed())
    }
}