class Solution {
    fun solution(my_string: String): String {
        return my_string.toList().map { it.lowercaseChar() }.sorted().joinToString("")
    }
}