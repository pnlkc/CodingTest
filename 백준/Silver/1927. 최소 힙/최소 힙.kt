import java.io.*
import java.util.*

fun main() {
    val bw = BufferedReader(InputStreamReader(System.`in`))
    val pQueue = PriorityQueue<Int>()
    val s = StringBuilder()

    repeat(bw.readLine().toInt()) {
        when(val input = bw.readLine().toInt()) {
            0 -> s.appendLine(pQueue.poll() ?: 0)
            else -> pQueue.add(input)
        }
    }

    println(s.toString())
}