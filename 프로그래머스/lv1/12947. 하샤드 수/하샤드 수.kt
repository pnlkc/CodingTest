class Solution {
    fun solution(x: Int): Boolean {
        return if (x%x.toString().sumOf { it -> it.toString().toInt() }==0) true else false
    }
}