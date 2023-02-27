class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0
        val pLong = p.toLong()
        for (i in 0..t.lastIndex - p.lastIndex) {
            if (t.slice(i..i + p.lastIndex).toLong() <= pLong) answer++
        }
        return answer
    }
}