import java.io.*
import java.util.*

fun main() {
    val bw = BufferedReader(InputStreamReader(System.`in`))
    val pQueue = PriorityQueue<Int>(reverseOrder())
    val s = StringBuilder()

    repeat(bw.readLine().toInt()) {
        when(val input = bw.readLine().toInt()) {
            0 -> s.appendLine(if (pQueue.isEmpty()) 0 else pQueue.poll())
            else -> pQueue.add(input)
        }
    }

    println(s.toString())
}
