class Solution {
    fun solution(n: Long): Long {
        return n.toString().toList().sortedDescending().joinToString("").toLong()
    }
}