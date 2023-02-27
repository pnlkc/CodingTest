class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int {
        var answer = 0
        for (s in s1) { if (s2.contains(s)) answer++ }
        return answer
    }
}
