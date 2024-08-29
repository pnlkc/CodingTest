data class Data(val no1: Int, val no2: Int, val score: Int)

fun main() {
    val N = readln().toInt()
    val arr = Array<MutableList<Data>>(N + 1) { mutableListOf() }

    for (n in 1..N) {
        val (no1, no2, score) = readln().split(" ").map { it.toInt() }
        arr[no1].add(Data(no1, no2, score))
    }

    arr.forEach { it.sortWith(compareByDescending { data -> data.score }) }

    val list = mutableListOf<Data>()

    for (n in 1..N) {
        if (arr[n].isNotEmpty()) {
            list.add(arr[n][0])
            if (arr[n].size >= 2) list.add(arr[n][1])
        }
    }

    list.sortByDescending { data -> data.score }

    println("${list[0].no1} ${list[0].no2}")
    println("${list[1].no1} ${list[1].no2}")
    println("${list[2].no1} ${list[2].no2}")
}