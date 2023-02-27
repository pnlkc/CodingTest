class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        val list = IntArray(number + 1) { 0 }
        for (i in 1..number) {
            for (j in 1..number) {
                if (i * j > number) break
                list[i * j]++
            }
        }
        return list.sumOf { if (it > limit) power else it }
    }
}