class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        var num = 0L
        var sum = 0L
        val sL = food_times.mapIndexed { index, i -> i to index }.sortedBy { it.first }

        for (i in sL.indices) {
            if (sL[i].first.toLong() == sum) continue
            val cNum = (sL.size - i) * (sL[i].first.toLong() - sum)
            if (num + cNum > k) {
                val slice = sL.slice(i..sL.lastIndex).sortedBy { it.second }
                return slice[((k - num) % slice.size).toInt()].second + 1
            } else {
                num += cNum
                sum = sL[i].first.toLong()
            }
        }
        return -1
    }
}