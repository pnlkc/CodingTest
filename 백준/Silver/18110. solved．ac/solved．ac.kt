import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val fifty = (n * 15) / 100 + if (((n * 15) % 100) / 10 >= 5) 1 else 0
    val pQueue = PriorityQueue<Int>()
    var sum = 0

    repeat(n) {
        val num = readln().toInt()
        pQueue.add(num)
    }

    for (i in 1..n - fifty) {
        if (i <= fifty) pQueue.poll() else sum += pQueue.poll()!!
    }

    if (n - fifty * 2 == 0) println(0)
    else println((sum / (n - fifty * 2)) + if (sum * 10 / (n - fifty * 2) % 10 >= 5) 1 else 0)
}