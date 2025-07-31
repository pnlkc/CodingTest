import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val Q = br.readLine().toInt()
    var sum = 0L
    val arr = LongArray(63)

    arr[0] = 1L

    for (i in 1..62) {
        arr[i] = arr[i - 1] * 2
    }
    
    repeat (Q) {
        val input = br.readLine()
        val num = input.drop(1).toLong()

        when (input[0]) {
            '+' -> sum += num
            '-' -> sum -= num
        }

        var idx = 62

        while (sum != 0L && arr[idx] > sum) {
            idx--
        }

        bw.write(if (sum == 0L) "0\n" else "${arr[idx]}\n")
    }

    bw.flush()
    bw.close()
}
