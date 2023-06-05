import java.util.Stack

class Solution {
    fun solution(arr: IntArray, flag: BooleanArray): IntArray {
        val answer = Stack<Int>()
        flag.forEachIndexed { idx, b -> 
            if (b) {
                val n = arr[idx]
                repeat(n * 2) { answer.push(n) }
            } else {
                repeat(arr[idx]) { answer.pop() }
            }
        }
        return answer.toIntArray()
    }
}