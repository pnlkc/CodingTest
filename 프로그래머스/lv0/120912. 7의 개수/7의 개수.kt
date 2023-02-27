class Solution {
    fun solution(array: IntArray): Int {
        return array.fold("") { acc, i -> acc + i.toString() }.count { it == '7' }
    }
}