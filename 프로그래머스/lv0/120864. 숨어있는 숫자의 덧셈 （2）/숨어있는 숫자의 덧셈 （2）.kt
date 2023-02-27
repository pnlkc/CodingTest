class Solution {
    fun solution(my_string: String): Int {
        var answer = 0
        var s = ""
        var lastI = -2
        my_string.forEachIndexed { i, c ->
            if (c.isDigit()) {
                if (lastI + 1 == i) {
                    lastI = i
                    s += c
                } else {
                    if (s.isNotEmpty()) answer += s.toInt()
                    s = c.toString()
                    lastI = i
                }
            }
        }
        if (s.isNotEmpty()) answer += s.toInt()
        return answer
    }
}