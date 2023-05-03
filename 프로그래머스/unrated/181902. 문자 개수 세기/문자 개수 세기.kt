class Solution {
    fun solution(my_string: String): IntArray {
        val map = (('A'..'Z') + ('a'..'z')).associateWith { 0 }.toMutableMap()
        my_string.forEach { map[it] = map[it]!! + 1 }
        return map.values.toIntArray()
    }
}