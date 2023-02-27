class Solution {
    fun solution(lines: Array<IntArray>): Int {
        val array = IntArray(201) { 0 }
        lines.forEach {
            for (i in it[0] until it[1]) array[i + 100]++
        }
        return array.count { it > 1 }
    }
}