class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        s.forEach {
            when (it) {
                in 'a'..'z' -> answer += if (it.code + n > 'z'.code) (it.code + n - 26).toChar() else (it.code + n).toChar()
                in 'A'..'Z' -> answer += if (it.code + n > 'Z'.code) (it.code + n - 26).toChar() else (it.code + n).toChar()
                else -> answer += it
            }
        }
        return answer
    }
}