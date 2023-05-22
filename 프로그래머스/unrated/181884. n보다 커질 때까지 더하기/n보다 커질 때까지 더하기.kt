class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var sum = 0
        for (number in numbers) {
            sum += number
            if (sum > n) break
        }
        return sum
    }
}