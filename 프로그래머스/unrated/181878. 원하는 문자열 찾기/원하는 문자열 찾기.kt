class Solution {
    fun solution(myString: String, pat: String): Int {
        return if (myString.lowercase().contains(pat.lowercase())) 1 else 0
    }
}