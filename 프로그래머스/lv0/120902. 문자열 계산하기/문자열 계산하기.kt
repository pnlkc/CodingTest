class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        var symbol = ""
        my_string.split(" ").forEach { s ->
            when (s) {
                "+" -> symbol = s
                "-" -> symbol = s
                else -> {
                    when (symbol) {
                        "-" -> answer -= s.toInt()
                        else -> answer += s.toInt()
                    }
                }
            }
        }
        return answer
    }
}