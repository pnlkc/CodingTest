import java.util.StringTokenizer

fun main() {
    val N = readln().toInt()
    val arr = IntArray(N)
    val st = StringTokenizer(readln())
    val preSum = LongArray(N)
    var sum = 0L

    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }

    preSum[0] = arr[0].toLong()

    for (i in 1 until N) {
        preSum[i] = preSum[i - 1] + arr[i]
    }

    for (i in 1 until N) {
        sum += preSum[i - 1] * arr[i]
    }

    println(sum)
}