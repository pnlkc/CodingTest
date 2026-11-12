class Solution {
    fun mySqrt(x: Int): Int {
        var result = 0

        for (i in 1..x) {
            if (i.toLong() * i <= x) result = i else break
        }

        return result
    }
}