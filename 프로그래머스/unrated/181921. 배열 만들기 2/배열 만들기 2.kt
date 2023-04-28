class Solution {
    fun solution(l: Int, r: Int): IntArray {
        return (l..r)
            .filter { it.toString().replace("5", "").replace("0", "").isEmpty() }
            .ifEmpty { listOf(-1) }
            .toIntArray()
    }
}