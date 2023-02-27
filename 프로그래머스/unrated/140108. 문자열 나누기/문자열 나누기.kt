class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var first: Char? = s.first()
        var r = intArrayOf(0, 0)
        for (i in s.indices) {
            if (first == null) first = s[i]
            if (s[i] == first) r[0]++ else r[1]++
            if (r[0] != 0 && r[0] == r[1]) {
                answer++
                first = null
                r = intArrayOf(0, 0)
            }
        }
        if (r[0] != 0 || r[1] != 0) answer++
        return answer
    }
}