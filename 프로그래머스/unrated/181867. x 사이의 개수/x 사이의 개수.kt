class Solution {
    fun solution(myString: String): IntArray {
        return myString.split('x').map { it.length }.toIntArray()
    }
}