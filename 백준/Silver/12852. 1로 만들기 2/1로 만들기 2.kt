import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val pQ = PriorityQueue(compareBy<Triple<Int, Int, MutableList<Int>>> { it.second })
    pQ.add(Triple(n, 0, mutableListOf(n)))
    if (n == 1) return println("0\n1")

    while (pQ.isNotEmpty()) {
        val (num, count, mList) = pQ.poll()!!

        if (num % 3 == 0) {
            val temp = mList.toMutableList().also { it.add(num / 3) }
            if (num / 3 == 1) return println("${count + 1}\n${temp.joinToString(" ")}")
            pQ.add(Triple(num / 3, count + 1, temp))
        }

        if (num % 2 == 0) {
            val temp = mList.toMutableList().also { it.add(num / 2) }
            if (num / 2 == 1) return println("${count + 1}\n${temp.joinToString(" ")}")
            pQ.add(Triple(num / 2, count + 1, temp))
        }

        if (num > 1) {
            val temp = mList.toMutableList().also { it.add(num - 1) }
            if (num - 1 == 1) return println("${count + 1}\n${temp.joinToString(" ")}")
            pQ.add(Triple(num - 1, count + 1, temp))
        }
    }
}