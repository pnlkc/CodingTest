import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = StringBuilder()

    val s = br.readLine()
    val num = br.readLine().toInt()
    val arr = Array(s.length + 1) { mutableMapOf<Char, Int>() }
    val exist = s.toSet()
    exist.forEach { arr[0][it] = 0 }

    s.forEachIndexed { idx, c ->
        exist.forEach {
            if (it == c) arr[idx + 1][it] = arr[idx][it]!! + 1
            else arr[idx + 1][it] = arr[idx][it]!!
        }
    }

    repeat(num) {
        val st = StringTokenizer(br.readLine())
        val c = st.nextToken()[0]
        val l = st.nextToken().toInt()
        val r = st.nextToken().toInt()
        if (!exist.contains(c)) string.append("${0}\n")
        else string.append("${arr[r + 1][c]!! - arr[l][c]!!}\n")
    }
    
    println(string.toString())
}