class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        return my_string.replaceRange(s until s + overwrite_string.length, overwrite_string)
    }
}