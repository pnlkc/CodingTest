import java.util.Stack

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }
        val stack = Stack<Int>()

        for (i in numbers.lastIndex downTo 1) {
            stack.add(numbers[i])
            while (stack.isNotEmpty() && stack.peek()!! <= numbers[i - 1]) {
                stack.pop()
            }
            if (stack.isNotEmpty()) answer[i - 1] = stack.peek()
            stack.add(numbers[i - 1])
        }

        return answer
    }
}