fun main() {
    val n = readln().toInt()
    val hArr = readln().split(" ").map { it.toInt() }
    val aArr = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { hArr[it] to aArr[it] }
    var r = 0L

    arr.sortBy { it.second }

    for (i in 0 until  n) {
        r += arr[i].first + arr[i].second * i
    }

    println(r)
}