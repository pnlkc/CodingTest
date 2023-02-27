class Solution {
    fun solution(n: Int): Int {
        var answer = 1
        while (true) {
            if (6 * answer % n == 0) break else answer++
        }
        return answer
    }
}