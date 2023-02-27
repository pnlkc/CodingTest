class Solution {
    fun solution(polynomial: String): String {
        val answer = mutableListOf<String>()
        var x = 0
        var a = 0
        polynomial.split(" + ").forEach { s ->
            when {
                s.contains('x') -> {
                    if (s.length == 1) x++ else x += s.slice(0 until s.lastIndex).toInt()
                }
                else -> a += s.toInt()
            }
        }
        if (x == 1) answer.add("x") else if (x != 0) answer.add("${x}x")
        if (a != 0) answer.add("$a")
        return answer.joinToString(" + ")
    }
}