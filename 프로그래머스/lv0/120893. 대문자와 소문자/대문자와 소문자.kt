class Solution {
    fun solution(my_string: String): String {
        return my_string.toList().joinToString("") { if (it.isLowerCase()) it.uppercase() else it.lowercase() }
    }
}