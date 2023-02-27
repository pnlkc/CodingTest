class Solution {
    fun solution(n: Int): Int {
        var top = 1.toBigInteger()
        var bottom = (n + 1).toBigInteger()
        
        for (i in 2 * n downTo 1) {
            top = top.multiply(i.toBigInteger())
        }
        
        for (j in n downTo 1) {
            bottom = bottom.multiply(j.toBigInteger()).multiply(j.toBigInteger())
        }

        return top.divide(bottom).toInt()
    }
}