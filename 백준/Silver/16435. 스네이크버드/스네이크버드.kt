fun main() {
    var (N, L) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()

    for (h in list) {
        if (L >= h) L++ else break
    }

    println(L)
}