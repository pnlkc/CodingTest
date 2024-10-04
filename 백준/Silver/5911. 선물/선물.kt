data class Data(val p: Int, val s: Int)

fun main() {
    val (N, B) = readln().split(" ").map { it.toInt() }
    val arr = Array(N) { Data(0, 0) }
    var result = 0

    for (i in 0 until N) {
        val (p, s) = readln().split(" ").map { it.toInt() }
        arr[i] = Data(p, s)
    }

    for (i in 0 until N) {
        val ori = arr[i]
        arr[i] = Data(arr[i].p / 2, arr[i].s)
        val temp =  arr.sortedBy { it.p + it.s }

        var sum = 0L
        var cnt = 0

        while (cnt < N) {
            if (sum + temp[cnt].p + temp[cnt].s <= B) {
                sum += temp[cnt].p.toLong() + temp[cnt].s
                cnt++
            } else {
                break
            }
        }

        result = maxOf(result, cnt)
        arr[i] = ori
    }

    println(result)
}