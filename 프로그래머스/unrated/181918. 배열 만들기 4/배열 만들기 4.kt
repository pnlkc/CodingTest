import java.util.Stack

class Solution {
    fun solution(arr: IntArray): IntArray {
        var i = 0
        val stk = Stack<Int>()
        
        while (i < arr.size) {
            when {
                stk.isEmpty() -> stk.push(arr[i++])
                stk.last() < arr[i] -> stk.push(arr[i++])
                else -> stk.pop()
            }
        }
        
        return stk.toIntArray()
    }
}