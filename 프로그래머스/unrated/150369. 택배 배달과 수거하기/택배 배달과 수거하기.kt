class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer = 0L
        val sum = longArrayOf(deliveries.sumOf { it.toLong() }, pickups.sumOf { it.toLong() })
        var i = n - 1

        while (i >= 0) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                i--
                continue
            }
            answer += (i + 1) * 2

            val left = intArrayOf(maxOf(0, cap - deliveries[i]), maxOf(0, cap - pickups[i]))
            sum[0] = sum[0] - cap + left[0]
            sum[1] = sum[1] - cap + left[1]
            deliveries[i] = maxOf(0, deliveries[i] - cap)
            pickups[i] = maxOf(0, pickups[i] - cap)

            for (j in i - 1 downTo 0) {
                if (left[0] == 0 && left[1] == 0) break
                if (left[0] == 0 && sum[1] == 0L) break
                if (left[1] == 0 && sum[0] == 0L) break
                if (left[0] != 0) {
                    if (deliveries[j] > left[0]) {
                        sum[0] = sum[0] - left[0]
                        deliveries[j] -= left[0]
                        left[0] = 0
                    } else {
                        sum[0] = sum[0] - deliveries[j]
                        left[0] -= deliveries[j]
                        deliveries[j] = 0
                    }
                }

                if (left[1] != 0) {
                    if (pickups[j] > left[1]) {
                        sum[1] = sum[1] - left[1]
                        pickups[j] -= left[1]
                        left[1] = 0
                    } else {
                        sum[1] = sum[1] - pickups[j]
                        left[1] -= pickups[j]
                        pickups[j] = 0
                    }
                }
            }
        }

        return answer
    }
}