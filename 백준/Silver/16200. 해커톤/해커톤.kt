fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var idx = 0
    var cnt = 0

    while (idx < n) {
        cnt++
        idx += list[idx]
    }

    println(cnt)
}