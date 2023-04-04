import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val token = StringTokenizer(br.readLine())
    val sum = IntArray(n + 1)
    val arr = IntArray(m)

    for (i in 0 until n) {
        sum[i + 1] = (sum[i] + token.nextToken().toInt()) % m
        arr[sum[i + 1]]++
    }

    println(arr[0] + arr.sumOf { it.toLong() * (it - 1) / 2 })
}