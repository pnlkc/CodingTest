class Solution {
    fun solution(emergency: IntArray): IntArray {
        val sortedD = emergency.sortedDescending()
        return emergency.map { sortedD.indexOf(it) + 1 }.toIntArray()
    }
}