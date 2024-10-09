import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
    val sb = StringBuilder()
    val map = mutableMapOf<Int, Boolean>()
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val st = StringTokenizer(br.readLine())
        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()
        if (N == 0 && M == 0) break
        map.clear()
        var cnt = 0
        var last = 0

        for (i in 0 until N) {
            val num = br.readLine().toInt()
            if (i == N - 1) last = num
            map[num] = true
        }

        for (i in 0 until M) {
            val num = br.readLine().toInt()
            if (num > last) continue
            if (map[num] != null) cnt++
        }

        sb.appendLine(cnt)
    }

    print(sb)
}