class Solution {
    fun solution(my_string: String, is_suffix: String): Int {
        return if (my_string.drop(maxOf(0, my_string.length - is_suffix.length)) == is_suffix) 1 else 0
    }
}