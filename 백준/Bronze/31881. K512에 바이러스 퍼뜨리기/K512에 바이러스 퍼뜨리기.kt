import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val (N, Q) = br.readLine().split(" ").map { it.toInt() }
    val arr = BooleanArray(N + 1)
    var cnt = N

    repeat(Q) {
        val input = br.readLine()

        when (input.first()) {
            '1' -> {
                val (_, x) = input.split(" ").map { it.toInt() }
                if (!arr[x]) {
                    arr[x] = true
                    cnt--
                }
            }
            '2' -> {
                val (_, x) = input.split(" ").map { it.toInt() }
                if (arr[x]) {
                    arr[x] = false
                    cnt++
                }
            }
            '3' -> {
                bw.write("$cnt\n")
            }
        }
    }

    bw.flush()
    bw.close()
}