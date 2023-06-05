import java.util.Stack

class Solution {
    fun solution(arr: IntArray): IntArray {
        val stk = Stack<Int>()
        
        for (i in arr.indices) {
            when {
                stk.isEmpty() -> stk.push(arr[i])
                stk.last() == arr[i] -> stk.pop()
                else -> stk.push(arr[i])
            }
        }
        
        return stk.ifEmpty { listOf(-1) }.toIntArray()
    }
}