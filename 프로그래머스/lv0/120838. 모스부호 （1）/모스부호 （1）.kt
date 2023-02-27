class Solution {
    fun solution(letter: String): String {
        var answer = ""
        val morse = mutableMapOf(
            ".-" to "a", "-..." to "b", "-.-." to "c", "-.." to "d", "." to "e", "..-." to "f",
            "--." to "g", "...." to "h", ".." to "i", ".---" to "j", "-.-" to "k", ".-.." to "l",
            "--" to "m", "-." to "n", "---" to "o", ".--." to "p", "--.-" to "q", ".-." to "r",
            "..." to "s", "-" to "t", "..-" to "u", "...-" to "v", ".--" to "w", "-..-" to "x",
            "-.--" to "y", "--.." to "z"
        )
        letter.split(" ").forEach {
            answer += morse[it]
        }
        return answer
    }
}