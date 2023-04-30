import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))
    var bit = 0

    repeat(br.readLine().toInt()) {
        val c = br.readLine().split(" ")

        when (c[0]) {
            "add" -> bit = bit or (1 shl (c[1].toInt() - 1))
            "remove" -> bit = bit and (1 shl (c[1].toInt() - 1)).inv()
            "check" -> sb.appendLine(if (bit and (1 shl (c[1].toInt() - 1)) == 0) 0 else 1)
            "toggle" -> bit = bit xor (1 shl (c[1].toInt() - 1))
            "all" -> bit = 0b11111111111111111111
            "empty" -> bit = 0
        }
    }

    println(sb.toString())
}