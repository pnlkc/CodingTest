class Solution {
    fun solution(str1: String, str2: String): Int {
        var answer: Int = 0
        if (str2.contains(str1)) answer = 1
        return answer
    }
}