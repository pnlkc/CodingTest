class Solution {
    fun solution(quiz: Array<String>): Array<String> {
        val answer = mutableListOf<String>()
        quiz.forEach { s ->
            val split = s.split(" = ")
            val f = split[0].split(" + ", " - ").map { it.toInt() }
            when (if (split[0].contains(" + ")) 1 else -1) {
                1 -> if (f[0] + f[1] == split[1].toInt()) answer.add("O") else answer.add("X")
                -1 -> if (f[0] - f[1] == split[1].toInt()) answer.add("O") else answer.add("X")
            }
        }
        return answer.toTypedArray()
    }
}