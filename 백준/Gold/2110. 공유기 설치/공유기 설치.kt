import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, c) = br.readLine().split(" ").map { it.toInt() }
    val arr = LongArray(n) { br.readLine().toLong() }
    arr.sort()
    var s = 0L
    var e = 1_000_000_000L

    while (s <= e) {
        val mid = (s + e) / 2
        var count = 1
        var cNum = arr.first()

        for (i in 1 until n) {
            if (arr[i] >= cNum + mid) {
                count++
                cNum = arr[i]
            }

            if (count >= c) break
        }

        if (count >= c) s = mid + 1 else e = mid - 1
    }

    println(e)
}