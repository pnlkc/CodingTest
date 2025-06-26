fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }
    var arr = BooleanArray(N)

    for (i in 0 until M) {
        arr[readln().toInt()] = true
    }

    repeat (K) {
        val temp = BooleanArray(N)

        for (i in 0 until N) {
            if (!arr[i]) continue

            val prev = if (i - 1 < 0) N - 1 else i - 1
            val next = if (i + 1 >= N) 0 else i + 1

            temp[prev] = !temp[prev]
            temp[next] = !temp[next]
        }

        arr = temp
    }

    println(arr.count { it })
}