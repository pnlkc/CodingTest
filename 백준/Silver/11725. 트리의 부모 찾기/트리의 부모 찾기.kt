import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val graph = Array(n) { mutableListOf<Int>() }
    val queue = LinkedList<Int>()
    val arr = IntArray(n)

    repeat(n - 1) {
        val (a, b) = readln().split(' ').map(String::toInt)
        graph[a - 1].add(b)
        graph[b - 1].add(a)
    }

    queue.add(1)

    while (queue.isNotEmpty()) {
        val cn = queue.poll()!!

        graph[cn - 1].forEach {
            if (arr[it - 1] == 0) {
                queue.add(it)
                arr[it - 1] = cn
            }
        }
    }

    (1 until n).forEach { sb.appendLine(arr[it]) }

    println(sb)
}