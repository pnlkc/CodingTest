fun main() {
    val N = readln().toInt()
    val arr = Array(N) { 0 to 0 }

    for (i in 0 until N) {
        readln().split(" ").map { it.toInt() }.run { arr[i] = this[0] to this[1] }
    }

    arr.sortWith(compareByDescending<Pair<Int, Int>> { it.first }.thenBy { it.second })
    println("${arr[0].first} ${arr[0].second} ${arr[1].first} ${arr[1].second}")

    arr.sortWith(compareBy<Pair<Int, Int>> { it.second }.thenByDescending { it.first })
    println("${arr[0].first} ${arr[0].second} ${arr[1].first} ${arr[1].second}")
}