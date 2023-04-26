class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        val arr = IntArray(included.size)
        for (i in included.indices) {
            if (i == 0) arr[0] = a else arr[i] = arr[i - 1] + d
        }
        return arr.foldIndexed(0) { idx, acc, i -> if (included[idx]) acc + i else acc }
    }
}