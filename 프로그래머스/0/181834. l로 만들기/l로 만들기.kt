class Solution {
    fun solution(myString: String): String {
        return myString.map { if (it < 'l') 'l' else it }.joinToString("")
    }
}