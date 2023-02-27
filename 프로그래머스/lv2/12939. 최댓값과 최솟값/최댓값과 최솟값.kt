class Solution {
    fun solution(s: String): String = "${s.split(" ").minOf { it.toInt() }} ${s.split(" ").maxOf { it.toInt() }}"
}