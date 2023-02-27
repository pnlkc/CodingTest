class Solution {
    fun solution(dots: Array<IntArray>): Int {
        return (dots.maxOf { it[0] } - dots.minOf { it[0] }) * (dots.maxOf { it[1] } - dots.minOf { it[1] })
    }
}