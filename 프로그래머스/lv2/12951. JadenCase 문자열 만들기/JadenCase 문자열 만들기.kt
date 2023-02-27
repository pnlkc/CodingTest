class Solution {
    fun solution(s: String): String {
        return s.lowercase().mapIndexed { index, c ->
            when (index) {
                0 -> if (c.isLetter()) c.uppercaseChar() else c
                in 1 until s.lastIndex -> if (s[index - 1] == ' ') c.uppercaseChar() else c
                else -> c
            }
        }.joinToString("")
    }
}