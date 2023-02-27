class Solution {
    fun solution(topping: IntArray): Int {
        var answer = 0
        val f = IntArray(10001) { 0 }
        var fn = 0
        val b = IntArray(10001) { 0 }
        var bn = topping.distinct().size
        topping.forEach { b[it]++ }
        topping.forEach {
            b[it]--
            if (b[it] == 0) bn--
            if (f[it] == 0) fn++
            f[it]++
            if (fn == bn) answer++
        }

        return answer
    }
}