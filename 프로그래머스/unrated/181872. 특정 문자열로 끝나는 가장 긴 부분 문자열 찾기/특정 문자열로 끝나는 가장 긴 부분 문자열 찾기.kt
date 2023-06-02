class Solution {
    fun solution(myString: String, pat: String): String {
        return myString.split(pat).dropLast(1).joinToString(pat) + pat
    }
}