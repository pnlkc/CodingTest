class Solution {
    fun solution(date1: IntArray, date2: IntArray): Int {
        val a = "${date1[0]}${String.format("%02d", date1[1])}${String.format("%02d", date1[2])}"
        val b = "${date2[0]}${String.format("%02d", date2[1])}${String.format("%02d", date2[2])}"
        return if (a < b) 1 else 0
    }
}