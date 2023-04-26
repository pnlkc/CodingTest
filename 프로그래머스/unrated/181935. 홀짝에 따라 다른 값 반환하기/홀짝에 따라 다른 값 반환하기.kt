class Solution {
    fun solution(n: Int): Int {
        return if (n % 2 == 0) {
            (1..n).fold(0) { acc, i -> if (i % 2 == 0) acc + (i * i) else acc }
        } else {
            (1..n).fold(0) { acc, i -> if (i % 2 == 1) acc + i else acc }
        }
    }
}