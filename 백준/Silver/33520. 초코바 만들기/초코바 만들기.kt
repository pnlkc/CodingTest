import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    var w = 0L
    var h = 0L

    for (i in 0 until N) {
        val (a, b) = br.readLine().split(" ").map { it.toLong() }

        w = maxOf(w, minOf(a, b))
        h = maxOf(h, maxOf(a, b))
    }

    println(w * h)
}