class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        return my_strings.foldIndexed("") { idx, acc, str ->
            val (s, e) = parts[idx]
            acc + str.slice(s..e)
        }
    }
}