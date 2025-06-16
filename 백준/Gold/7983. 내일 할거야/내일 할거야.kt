import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Data(val d: Int, val t: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n) {
        val st = StringTokenizer(br.readLine())
        Data(st.nextToken().toInt(), st.nextToken().toInt())
    }.sortedBy { it.t }

    var result = arr[n - 1].t

    for (i in n - 1 downTo 0) {
        if (result > arr[i].t) result = arr[i].t
        result -= arr[i].d
    }

    println(result)
}