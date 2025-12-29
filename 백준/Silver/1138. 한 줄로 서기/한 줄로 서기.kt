import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var q = LinkedList<Int>()

    q.add(n)

    for (i in n - 1 downTo 1) {
        val temp = LinkedList<Int>()
        var cnt = 0

        while (list[i - 1] > cnt) {
            temp.add(q.poll()!!)
            cnt++
        }

        temp.add(i)
        temp.addAll(q)
        q = temp
    }

    while (q.isNotEmpty()) {
        if (sb.isNotEmpty()) sb.append(" ")
        sb.append(q.poll()!!)
    }

    println(sb)
}