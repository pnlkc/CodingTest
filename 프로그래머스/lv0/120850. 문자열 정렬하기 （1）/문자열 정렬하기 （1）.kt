class Solution {
    fun solution(my_string: String): IntArray {
        return my_string.filter { it.isDigit() }.map { it.digitToInt() }.sorted().toIntArray()
    }
}