data class Data(val num: Int, val g: Int, val s: Int, val b: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Data>()

    for (i in 1..N) {
        val (num, g, s, b) = readln().split(" ").map { it.toInt() }

        list.add(Data(num, g, s, b))
    }

    list.sortWith(compareByDescending<Data> { it.g }.thenByDescending { it.s }.thenByDescending { it.b })

    var prev = Data(-1, -1, -1, -1)
    var r = 0
    var cnt = 0

    for (data in list) {
        if (prev.g == data.g && prev.s == data.s && prev.b == data.b) {
            cnt++
        } else {
            cnt++
            r = cnt
            prev = data
        }

        if (data.num == M) {
            println(r)
            return
        }
    }
}