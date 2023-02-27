class Solution {
    fun solution(a: Int, b: Int): Long {
        return if (a<=b) (a.toLong()..b.toLong()).sum() else (a.toLong() downTo b.toLong()).sum()
    }
}