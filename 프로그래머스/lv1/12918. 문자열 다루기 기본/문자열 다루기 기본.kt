class Solution {
    fun solution(s: String): Boolean {
        var answer = true
        if (s.length == 4 || s.length == 6) {
            for (i in s) {
                if (i.isDigit()) {
                    answer = true
                } else {
                    answer = false
                    break
                }
            }
        } else {
            answer = false
        }
        return answer
    }
}