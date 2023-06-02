class Solution {
    fun solution(myString: String, pat: String): Int {
        var answer = 0
        
        p@for (i in 0..myString.length - pat.length) {
            for (j in pat.indices) {
                if (myString[i + j] != pat[j]) continue@p
            }
            answer++
        }
        
        return answer
    }
}