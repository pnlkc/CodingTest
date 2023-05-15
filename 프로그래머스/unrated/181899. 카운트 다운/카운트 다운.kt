class Solution {
    fun solution(start: Int, end: Int): IntArray {
        return (start downTo end).toList().toIntArray()
    }
}