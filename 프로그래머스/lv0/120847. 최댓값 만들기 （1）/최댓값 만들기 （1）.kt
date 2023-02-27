class Solution {
    fun solution(numbers: IntArray): Int {
        numbers.sortDescending()
        return numbers[0] * numbers[1]
    }
}