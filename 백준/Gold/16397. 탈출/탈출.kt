import java.util.LinkedList

data class Data(val num: Int, val cnt: Int)

fun main() {
    val (N, T, G) = readln().split(" ").map { it.toInt() }
    val isVisit = BooleanArray(100_000)
    val q = LinkedList<Data>()

    q.add(Data(N, 0))
    isVisit[N] = true

    while(q.isNotEmpty()) {
        val (cNum, cCnt) = q.poll()!!

        if (cNum == G) {
            println(cCnt)
            return
        }

        if (cCnt == T) continue

        if (cNum + 1 <= 99_999 && !isVisit[cNum + 1]) {
            q.add(Data(cNum + 1, cCnt + 1))
            isVisit[cNum + 1] = true
        }

        var nNum = cNum * 2

        if (nNum <= 99_999) {
            var sub = 1

            if (nNum != 0) {
                repeat(nNum.toString().length - 1) {
                    sub *= 10
                }

                nNum -= sub

                if (!isVisit[nNum]) {
                    q.add(Data(nNum, cCnt + 1))
                    isVisit[nNum] = true
                }
            }
        }
    }

    println("ANG")
}