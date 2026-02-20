import java.util.LinkedList

data class Data(val time: Int, val cnt: Int, val isStart: Boolean)

fun main() {
    val (m, s) = readln().split(":").map { it.toInt() }
    val target = m * 60 + s
    val dt = intArrayOf(30, 10, 60, 600)
    val q = LinkedList<Data>()
    val isVisit = mutableMapOf<Int, Boolean>()

    q.add(Data(0, 0, false))
    isVisit[0] = true

    while (q.isNotEmpty()) {
        val (cTime, cCnt, cIsStart) = q.poll()!!

        if (cTime == target) {
            if (cIsStart) {
                println(cCnt)
                return
            } else {
                q.add(Data(cTime, cCnt + 1, true))
            }
        }

        for (d in 0..3) {
            val n = cTime + dt[d]

            if (n <= target && isVisit[n] != true) {
                val temp = cIsStart || d == 0

                q.add(Data(n, cCnt + 1, temp))
                isVisit[n] = true
            }
        }
    }
}