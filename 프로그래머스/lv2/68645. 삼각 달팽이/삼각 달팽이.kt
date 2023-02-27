class Solution {
    lateinit var result: Array<IntArray>

    fun solution(n: Int): IntArray {
        val answer = mutableListOf<Int>()
        result = Array(n) { intArrayOf() }
        for (i in result.indices) {
            result[i] = IntArray(i + 1) { 0 }
        }
        calc(n)
        result.forEach { intArray -> intArray.forEach { num -> answer.add(num) } }
        return answer.toIntArray()
    }

    fun calc(size:Int, start: Int = 1, x: Int = 0, y: Int = 0) {
        var num = start
        for (i in 1..size) {
            result[y + i - 1][x] = num
            num++
        }

        for (j in 1 until size) {
            result[y + size - 1][x + j] = num
            num++
        }

        for (k in 1..size - 2) {
            result[y + size - 1 - k][x + size - k - 1] = num
            num++
        }

        if (size > 3) {
            calc(size - 3, num, x + 1, y + 2)
        }
    }
}