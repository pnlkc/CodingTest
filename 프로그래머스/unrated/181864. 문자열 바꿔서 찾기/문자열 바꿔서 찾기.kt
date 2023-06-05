class Solution {
    fun solution(myString: String, pat: String): Int {
        return if (myString.map { if (it == 'A') 'B' else 'A' }.joinToString("").contains(pat)) 1 else 0
    }
}