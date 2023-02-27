import java.util.Stack
class Solution {
    fun solution(s: String): Int {
        var answer = 0
        val stack = Stack<Int>()
        s.split(" ").forEach {
            if (it == "Z") {
                if (stack.isNotEmpty()) {
                    answer -= stack.pop()
                }
            } else {
                answer += it.toInt()
                stack.add(it.toInt())
            }
        }
        return answer
    }
}