data class Data(val d: Int, val t: Int)

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { Data(0, 0) }

    for (i in 0 until n) {
        val (d, t) = readln().split(" ").map { it.toInt() }

        arr[i] = Data(d, t)
    }

    arr.sortWith(compareBy<Data> { it.t })

    var result = arr[n - 1].t

    for (i in n - 1 downTo 0) {
        if (result > arr[i].t) result = arr[i].t

        result -= arr[i].d
    }

    println(result)
}