import java.util.LinkedList

data class Data(val n: String, val c: Int)

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val len = N.toString().length
    val NUM = 1_000_000
    val q = LinkedList<Data>()
    val isVisit = Array(11) { BooleanArray(NUM + 1) }
    var result = -1

    q.add(Data(N.toString(), 0))
    isVisit[0][N] = true

    while (q.isNotEmpty()) {
        val c = q.poll()!!

        if (c.c == K) {
            if (c.n.first() != '0') result = maxOf(result, c.n.toInt())
            continue
        }

        for (i in 0 until len - 1) {
            for (j in i + 1 until len) {
                val cArr = c.n.toCharArray()
                val temp = c.n[i]
                cArr[i] = cArr[j]
                cArr[j] = temp
                
                if (cArr[0] == '0') continue
                
                val nn = cArr.joinToString("")

                if (!isVisit[c.c + 1][nn.toInt()]) {
                    q.add(Data(nn, c.c + 1))
                    isVisit[c.c + 1][nn.toInt()] = true
                }
            }
        }
    }

    println(result)
}