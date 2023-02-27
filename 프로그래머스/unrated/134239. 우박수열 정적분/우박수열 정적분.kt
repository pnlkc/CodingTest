class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        val answer = DoubleArray(ranges.size) { 0.0 }
        val list = mutableListOf(k.toDouble())
        var num = k.toDouble()
        while (num != 1.0) {
            if (num % 2 != 0.0) {
                num = num * 3 + 1
                list.add(num)
            } else {
                num /= 2
                list.add(num)
            }
        }
        
        val area = DoubleArray(list.size) { 0.0 }

        for (i in list.indices) {
            if (i - 1 in list.indices) area[i] = area[i - 1] + (list[i - 1] + list[i]) / 2
        }

        for (i in ranges.indices) {
            val (s, e) = ranges[i]
            when {
                list.lastIndex + e - s == 0 -> answer[i] = 0.0
                list.lastIndex + e - s < 0 -> answer[i] = -1.0
                else -> answer[i] = area[list.lastIndex + e] - area[s]
            }
        }

        return answer
    }
}