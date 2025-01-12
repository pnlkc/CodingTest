import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    val st = StringTokenizer(readln())

    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }

    val preSum = IntArray(N + 1)

    for (i in 0 until N) {
        preSum[i + 1] = preSum[i] + arr[i]
    }

    var result = 0
    var diff = Int.MAX_VALUE

    for (i in 0 until N - 1) {
        for (j in i + 1 until N) {
            var s = i
            var e = j

            while (s <= e) {
                val mid = (s + e) / 2
                val sum = preSum[j + 1] - preSum[i]
                val fSum = preSum[mid + 1] - preSum[i]

                when {
                    sum - fSum > fSum -> s = mid + 1
                    sum - fSum < fSum -> e = mid - 1
                    else -> {
                        if (diff == 0) result = maxOf(result, sum) else result = sum
                        diff = 0
                        break
                    }
                }

                if (diff > abs(fSum - (sum - fSum))) {
                    result = sum
                    diff = abs(fSum - (sum - fSum))
                } else if (diff == abs(fSum - (sum - fSum))) {
                    result = maxOf(result, sum)
                }
            }
        }
    }

    println(result)
}