fun main() {
    val N = readln().toInt()
    val pL = readln().split(" ").map { it.toInt() }.toMutableList()
    val arr = Array(N + 1) { 0 to 0 }

    for (i in 1..N) {
        readln().split(" ").map { it.toInt() }.run { arr[i] = this[0] to this[1] }
    }

    arr.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })

    var result = 0
    arr[0] = arr[1]

    for (i in 1..N) {
        if (pL[arr[i].first - 1] <= 0) continue

        result += arr[i].second
        result += if (arr[i - 1].first == arr[i].first) arr[i].second - arr[i - 1].second else 60
        pL[arr[i].first - 1]--
    }

    println(result)
}