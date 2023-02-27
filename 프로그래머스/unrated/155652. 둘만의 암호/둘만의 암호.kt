class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val f = ('a'..'z').filter { !skip.contains(it) }
        return s.map { f[(f.indexOf(it) + index) % f.size] }.joinToString("")
    }
}