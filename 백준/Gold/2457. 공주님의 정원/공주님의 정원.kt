data class Data(val s: Int, val e: Int)

fun main() {
    val N = readln().toInt()
    val arr = Array(N) { Data(0, 0) }

    for (i in 0 until N) {
        val (sm, sd, em, ed) = readln().split(" ").map { it.toInt() }
        arr[i] = Data(
            "${sm}${if (sd < 10) "0$sd" else sd}".toInt(),
            "${em}${if (ed < 10) "0$ed" else ed}".toInt()
        )
    }

    arr.sortWith(compareBy<Data> { it.s }.thenByDescending { it.e })

    var s = 301
    var c = 0
    var idx = 0
    var cnt = 0

    while (c < 1201) {
        val prev = idx

        for (i in idx until N) {
            if (arr[i].s > s) break

            if (c < arr[i].e) {
                c = arr[i].e
                idx = i + 1
            }
        }

        if (prev == idx) break

        s = c
        cnt++
    }

    println(if (c < 1201) 0 else cnt)
}