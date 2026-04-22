import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    var a = BufferedReader(InputStreamReader(System.`in`))
    val c = a.readLine().toInt()
    var b = BufferedWriter(OutputStreamWriter(System.out))

    for (i in c downTo 1) {
        b.write(i.toString() + "\n")
    }

    b.flush()
    b.close()
}