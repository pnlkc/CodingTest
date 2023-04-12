import java.io.*
import java.util.*

fun main() {
    val bw = BufferedReader(InputStreamReader(System.`in`))
    val pQueue = PriorityQueue(compareBy<Int> { if (it < 0) -it else it }.thenBy { it })
    val s = StringBuilder()

    repeat(bw.readLine().toInt()) {
        bw.readLine().toInt().run {
            if (this == 0) s.appendLine(pQueue.poll() ?: 0) else pQueue.add(this)
        }
    }

    println(s.toString())
}