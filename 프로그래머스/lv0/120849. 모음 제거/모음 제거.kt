class Solution {
    fun solution(my_string: String): String {
        val vowel = charArrayOf('a', 'e', 'i', 'o', 'u')
        return my_string.toCharArray().filter { !vowel.contains(it) }.joinToString("")
    }
}