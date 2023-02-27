class Solution {
    fun solution(chicken: Int): Int {
        var answer = chicken / 10
        var c = answer + chicken % 10
        while (c >= 10) {
            answer += c / 10
            c = c / 10 + c % 10
        }
        return answer
    }
}