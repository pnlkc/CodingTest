class Solution {
    fun solution(str1: String, str2: String): String {
        val sb = StringBuilder()
        str1.forEachIndexed { idx, c -> sb.append(c).append(str2[idx]) }
        return sb.toString()
    }
}