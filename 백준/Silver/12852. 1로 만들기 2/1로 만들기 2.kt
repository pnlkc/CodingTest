import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val pQ = PriorityQueue(compareBy<Triple<Int, Int, String>> { it.second })
    pQ.add(Triple(n, 0, "$n"))
    if (n == 1) return println("0\n1")

    while (pQ.isNotEmpty()) {
        val (num, count, s) = pQ.poll()!!

        if (num % 3 == 0) {
            if (num / 3 == 1) return println("${count + 1}\n${s + " ${num / 3}"}")
            pQ.add(Triple(num / 3, count + 1, s + " ${num / 3}"))
        }

        if (num % 2 == 0) {
            if (num / 2 == 1) return println("${count + 1}\n${s + " ${num / 2}"}")
            pQ.add(Triple(num / 2, count + 1, s + " ${num / 2}"))
        }

        if (num > 1) {
            if (num - 1 == 1) return println("${count + 1}\n${s + " ${num - 1}"}")
            pQ.add(Triple(num - 1, count + 1, s + " ${num - 1}"))
        }
    }
}