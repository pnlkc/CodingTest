class Solution {
    fun solution(num: Int, k: Int): Int {
        return if (num.toString().indexOf(k.toString()) != -1) num.toString().indexOf(k.toString()) + 1 else -1
    }
}