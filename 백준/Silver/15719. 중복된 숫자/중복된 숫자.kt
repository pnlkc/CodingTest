import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val isExist = BooleanArray(N + 1)
    var cnt = 0
    var num = 0

    while (cnt < N) {
        val c = br.read().toChar()

        if (c !in '0'..'9') {
            if (isExist[num]) {
                println(num)
                return
            }

            isExist[num] = true
            num = 0
            cnt++
            continue
        } else {
            num *= 10
            num += c.digitToInt()
        }
    }
}
