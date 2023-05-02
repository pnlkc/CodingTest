class Solution {
    fun solution(my_string: String, n: Int): String {
        return my_string.slice(my_string.lastIndex - n + 1..my_string.lastIndex)
    }
}