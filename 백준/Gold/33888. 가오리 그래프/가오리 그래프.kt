import java.util.LinkedList

data class Data(val n: Int, val p: Int)

fun main() {
    val N = readln().toInt()
    val arr = Array(N + 1) { mutableListOf<Int>() }

    repeat(N + 3) {
        val (u, v) = readln().split(" ").map { it.toInt() }

        arr[u].add(v)
        arr[v].add(u)
    }

    val result = IntArray(6)
    val q = LinkedList<Data>()
    val isVisit = BooleanArray(N + 1)

    for (i in 1..N) {
        if (arr[i].size == 1) {
            q.add(Data(i, i))
            isVisit[i] = true
            result[5] = i
        }
    }

    while (q.isNotEmpty()) {
        val (cn, cp) = q.poll()!!

        for (n in arr[cn]) {
            if (isVisit[n]) continue

            when (arr[n].size) {
                3 -> {
                    if (arr[cp].size == 4) {
                        if (result[3] == 0) result[3] = n else result[1] = n
                        q.add(Data(n, n))
                    } else {
                        if (result[0] == 0) {
                            result[0] = n
                        }
                    }
                }
                4 -> {
                    if (result[4] == 0) {
                        result[4] = n
                        q.add(Data(n, n))
                    } else {
                        result[2] = n
                    }
                }
                else -> {
                    q.add(Data(n, cp))
                }
            }

            isVisit[n] = true
        }
    }
    
    if (result[1] > result[3]) {
        val temp = result[1]

        result[1] = result[3]
        result[3] = temp
    }

    println(result.joinToString(" "))
}