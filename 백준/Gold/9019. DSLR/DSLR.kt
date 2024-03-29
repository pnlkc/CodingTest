import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()

    repeat(tc) {
        val arr = Array(10_001) { Triple(0, -1, ' ') }
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(a to 0)

        while (queue.isNotEmpty()) {
            val (cn, cd) = queue.poll()!!

            if (cn == b) break
            if (cd > arr[cn].first) continue

            val logic: (Int, Char) -> Unit = { num, command ->
                if (arr[num].first == 0 || arr[num].first > cd + 1) {
                    arr[num] = Triple(cd + 1, cn, command)
                    queue.add(num to cd + 1)
                }
            }

            logic(cn * 2 % 10_000, 'D')
            logic(if (cn == 0) 9999 else cn - 1, 'S')
            logic(cn % 1000 * 10 + cn / 1000, 'L')
            logic(cn / 10 + cn % 10 * 1000, 'R')
        }

        val temp = StringBuilder()
        var cNum = b

        repeat(arr[cNum].first) {
            val (_, prev, command) = arr[cNum]
            temp.append(command)
            cNum = prev
        }

        sb.appendLine(temp.reverse())
    }

    println(sb)
}