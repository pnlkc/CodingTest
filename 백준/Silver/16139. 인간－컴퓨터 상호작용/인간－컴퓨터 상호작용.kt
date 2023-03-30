import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
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
        val (c, l, r) = br.readLine().split(" ")
        if (!exist.contains(c[0])) string.append("${0}\n")
        else string.append("${arr[r.toInt() + 1][c[0]]!! - arr[l.toInt()][c[0]]!!}\n")
    }

    bw.write(string.toString())
    bw.flush()
    bw.close()
}