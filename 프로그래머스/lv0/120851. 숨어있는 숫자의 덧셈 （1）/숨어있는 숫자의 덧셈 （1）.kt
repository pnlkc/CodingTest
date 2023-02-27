class Solution {
    fun solution(my_string: String): Int {
        return my_string.filter { it.isDigit() }.sumOf { it.toString().toInt() }
    }
}