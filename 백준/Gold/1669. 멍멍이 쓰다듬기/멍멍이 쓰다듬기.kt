fun main() {
    val (X, Y) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf(0L)

    if (Y - X == 0) {
        println(0)
        return
    }

    var n = 1

    while (true) {
        list.add(n + list[n - 1] + n - 1)
        if (list[n] > Int.MAX_VALUE) break
        n++
    }

    var idx = 0

    while (list[idx + 1] <= Y - X) {
        idx++
    }

    var result = idx * 2 - 1
    var diff = (Y - X - list[idx]).toInt()

    while (diff > 0) {
        result += diff / idx
        diff %= idx
        idx--
    }

    println(result)
}