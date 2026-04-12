import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val q = st.nextToken().toInt()
    val dp = IntArray(n + 1)
    val preSum = LongArray(n + 1)

    st = StringTokenizer(br.readLine())

    for (i in 0 until n) {
        val c = st.nextToken().toInt()

        dp[i + 1] = if (c == k) 0 else dp[i] + 1
        preSum[i + 1] = preSum[i] + dp[i + 1]
    }

    st = StringTokenizer(br.readLine())

    repeat(q) {
        sb.appendLine(preSum[st.nextToken().toInt()])
    }

    print(sb)
}