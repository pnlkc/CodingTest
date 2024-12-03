fun main() {
    val N = readln().toInt()
    val arr = Array(N + 1) { 0 to 0 }

    for (i in 1..N) {
        arr[i] = readln().toInt() to i
    }

    arr.sortBy { p: Pair<Int, Int> -> p.first }

    var max = 0

    for (i in N downTo 1) {
        if (arr[i].second - i > max) max = arr[i].second - i
    }

    println(max + 1)
}