class Solution {
    fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
        val answer = mutableListOf<Int>()
        intStrs.forEach {
            it.slice(s until s + l).toInt().run { if (this > k) answer.add(this) }
        }
        return answer.toIntArray()
    }
}