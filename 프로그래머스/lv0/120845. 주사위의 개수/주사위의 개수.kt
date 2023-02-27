class Solution {
    fun solution(box: IntArray, n: Int): Int {
        return return box.fold(1) { acc, i -> i / n * acc }
    }
}