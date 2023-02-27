class Solution {
    fun solution(citations: IntArray): Int {
        val maxCitation = citations.filter { c -> c <= citations.count { it >= c } }.maxOrNull() ?: 0
        val count = citations.count { it > maxCitation }
        return if (maxCitation > count) maxCitation else count
    }
}