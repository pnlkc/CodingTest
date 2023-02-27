class Solution {
    fun solution(numbers: IntArray): Int {
        numbers.sort()
        return maxOf(numbers[0] * numbers[1], numbers.last() * numbers[numbers.lastIndex - 1])
    }
}