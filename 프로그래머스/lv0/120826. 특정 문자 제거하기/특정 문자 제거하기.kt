class Solution {
    fun solution(my_string: String, letter: String): String {
        return my_string.toCharArray().filter { it.toString() != letter }.joinToString("")
    }
}