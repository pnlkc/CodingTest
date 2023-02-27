class Solution {
    fun solution(array: IntArray): Int {
        array.sort()
        return array[array.size / 2]
    }
}