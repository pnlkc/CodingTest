import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    var a = BufferedReader(InputStreamReader(System.`in`))
    val b = BufferedWriter(OutputStreamWriter(System.out))
    repeat(a.readLine().toInt()) {
        val c = StringTokenizer(a.readLine())
        val d = (c.nextToken().toInt() + c.nextToken().toInt()).toString()
        b.write(d + "\n")
    }
    b.flush()
    b.close()
}