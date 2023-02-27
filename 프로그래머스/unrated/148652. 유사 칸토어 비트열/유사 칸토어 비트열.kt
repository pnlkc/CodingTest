class Solution {
    fun solution(n: Int, l: Long, r: Long): Int {
        var sumL = 0L
        var tempL = l - 1
        var sumR = 0L
        var tempR = r

        for (i in n - 1 downTo 0) {
            var dN = 1L
            repeat(i) { dN *= 5 }
            var result = 1L
            repeat(i) { result *= 4 }
            when {
                tempL / dN == 2L -> {
                    sumL += result * 2
                    break
                }
                tempL / dN > 2L -> result *= tempL / dN - 1
                tempL / dN < 2L -> result *= tempL / dN
            }
            sumL += result
            tempL %= dN
        }

        for (i in n - 1 downTo 0) {
            var dN = 1L
            repeat(i) { dN *= 5 }
            var result = 1L
            repeat(i) { result *= 4 }
            when {
                tempR / dN == 2L -> {
                    sumR += result * 2
                    break
                }
                tempR / dN > 2L -> result *= tempR / dN - 1
                tempR / dN < 2L -> result *= tempR / dN
            }
            sumR += result
            tempR %= dN
        }
        
        return (sumR - sumL).toInt()
    }
}