import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val (p, m) = readln().split(" ").map { it.toInt() }
    var q = LinkedList<Pair<Int, MutableList<String>>>()

    for (i in 0 until p) {
        val (level, id) = readln().split(" ")

        if (q.isEmpty()) {
            q.add(level.toInt() to mutableListOf("$level $id"))
        } else {
            val temp = LinkedList<Pair<Int, MutableList<String>>>()
            var flag = false

            while (q.isNotEmpty()) {
                val (l, list) = q.pollFirst()!!

                if (!flag && list.size < m && level.toInt() in l - 10..l + 10) {
                    list.add("$level $id")
                    flag = true
                }

                temp.add(l to list)
            }

            if (!flag) {
                temp.add(level.toInt() to mutableListOf("$level $id"))
            }

            q = temp
        }
    }

    while (q.isNotEmpty()) {
        val (l, list) = q.pollFirst()!!

        list.sortBy { it.split(" ")[1] }
        sb.appendLine(if (list.size == m) "Started!" else "Waiting!")
        list.forEach { sb.appendLine(it) }
    }

    print(sb)
}