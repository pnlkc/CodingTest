import java.util.PriorityQueue

fun main() {
    val (n, k) = readln().split(' ').map(String::toInt)
    val pQ = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val time = IntArray(100_001) { -1 }

    pQ.add(n to 0)
    time[n] = 0

    while (pQ.isNotEmpty()) {
        val (cn, ck) = pQ.poll()!!

        if (time[cn] != -1 && ck > time[cn]) continue

        val arr = intArrayOf(cn + 1, cn - 1, cn * 2)
        val tR = intArrayOf(1, 1, 0)

        for (i in 0..2) {
            if (arr[i] < 0 || arr[i] > 100_000) continue
            if (time[arr[i]] == -1 || time[arr[i]] > ck + tR[i]) {
                time[arr[i]] = ck + tR[i]
                pQ.add(arr[i] to time[arr[i]])
            }
        }
    }

    println(time[k])
}