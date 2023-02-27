class Solution {
    fun solution(numbers: IntArray, num1: Int, num2: Int): IntArray {
        return numbers.slice(num1..num2).toIntArray()
    }
}