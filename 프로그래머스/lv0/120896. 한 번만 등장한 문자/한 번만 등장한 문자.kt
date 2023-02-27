class Solution {
    fun solution(s: String): String {
        return s.toCharArray().distinct().filter { c -> s.count { it == c } == 1 }.sorted().joinToString("")
    }
}