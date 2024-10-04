data class Data(val p: Int, val s: Int)

fun main() {
    val (N, B) = readln().split(" ").map { it.toInt() }
    val arr = Array(N) { Data(0, 0) }
    var result = 0

    for (i in 0 until N) {
        val (p, s) = readln().split(" ").map { it.toInt() }
        arr[i] = Data(p, s)
    }

    arr.sortBy { it.p + it.s }

    for (i in 0 until N) {
        val ori = arr[i]
        arr[i] = Data(arr[i].p / 2, arr[i].s)

        var sum = 0L
        var cnt = 0

        while (cnt < N) {
            if (sum + arr[cnt].p + arr[cnt].s <= B) {
                sum += arr[cnt].p.toLong() + arr[cnt].s
                cnt++
            } else {
                break
            }
        }
        
        if (cnt < i && sum + ori.p / 2 + ori.s <= B) {
            cnt++
        }

        result = maxOf(result, cnt)
        arr[i] = ori
    }

    println(result)
}