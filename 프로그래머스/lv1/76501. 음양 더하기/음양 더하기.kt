class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        for (i in absolutes.indices) {
            if (!signs[i]) absolutes[i] *= -1
        }
        return absolutes.sum()
    }
}