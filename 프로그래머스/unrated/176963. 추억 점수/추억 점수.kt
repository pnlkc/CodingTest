class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val map = name.zip(yearning.toTypedArray()).toMap()
        return photo.map { p -> p.sumOf { n -> map[n] ?: 0 } }.toIntArray()
    }
}