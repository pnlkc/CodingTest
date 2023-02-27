import java.util.Stack
class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer = 0
        val string = Stack<Int>()
        for (i in ingredient) {
            string.add(i)
            if (string.size >= 4) {
                if (string[string.lastIndex] != 1) continue 
                if (string[string.lastIndex - 1] != 3) continue 
                if (string[string.lastIndex - 2] != 2) continue 
                if (string[string.lastIndex - 3] != 1) continue
                answer++
                string.pop()
                string.pop()
                string.pop()
                string.pop()
            }
        }
        return answer
    }
}