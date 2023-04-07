class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer = 0L
        var sumD = deliveries.sumOf { it.toLong() }
        var sumP = pickups.sumOf { it.toLong() }
        var i = n - 1

        while (i >= 0) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                i--
                continue
            }
            answer += (i + 1) * 2

            val left = intArrayOf(maxOf(0, cap - deliveries[i]), maxOf(0, cap - pickups[i]))
            sumD -= cap - left[0]
            sumP -= cap - left[1]
            deliveries[i] = maxOf(0, deliveries[i] - cap)
            pickups[i] = maxOf(0, pickups[i] - cap)

            for (j in i - 1 downTo 0) {
                if (left[0] == 0 && left[1] == 0) break
                if (left[0] == 0 && sumP == 0L) break
                if (left[1] == 0 && sumD == 0L) break
                if (left[0] != 0) {
                    if (deliveries[j] > left[0]) {
                        sumD -= left[0]
                        deliveries[j] -= left[0]
                        left[0] = 0
                    } else {
                        sumD -= deliveries[j]
                        left[0] -= deliveries[j]
                        deliveries[j] = 0
                    }
                }

                if (left[1] != 0) {
                    if (pickups[j] > left[1]) {
                        sumP -= left[1]
                        pickups[j] -= left[1]
                        left[1] = 0
                    } else {
                        sumP -= pickups[j]
                        left[1] -= pickups[j]
                        pickups[j] = 0
                    }
                }
            }
        }

        return answer
    }
}