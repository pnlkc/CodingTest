class Solution {
    fun solution(binomial: String): Int {
        val (a, c, b) = binomial.split(' ')
        return when (c) {
            "+" -> a.toInt() + b.toInt() 
            "-" -> a.toInt() - b.toInt()
            else -> a.toInt() * b.toInt()
        }
    }
}