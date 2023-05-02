class Solution {
    fun solution(number: String): Int {
        return number.sumOf { it.digitToInt() } % 9
    }
}