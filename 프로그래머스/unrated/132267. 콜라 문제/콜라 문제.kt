class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer = 0
        var empty = n
        while (empty >= a) {
            answer += empty / a * b
            empty = empty / a * b + empty % a
        }
        return answer
    }
}