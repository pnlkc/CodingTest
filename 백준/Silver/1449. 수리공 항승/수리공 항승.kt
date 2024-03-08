fun main() {
    val (N, L) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var prev = list[0]
    var cnt = 1

    for (num in list) {
        if (num - prev <= L - 1) continue
        else {
            prev = num
            cnt++
        }
    }

    println(cnt)
}