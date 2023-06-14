import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(' ').map(String::toInt)
    val map = mutableMapOf<String, String>()

    repeat(n) {
        val (site, password) = br.readLine().split(' ')
        map[site] = password
    }

    repeat(m) {
        sb.appendLine(map[br.readLine()])
    }

    println(sb)
}