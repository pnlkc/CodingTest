fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Boolean>()
    var cnt = 0

    for (i in 0 until n) {
        var str = readln()

        while (str.isNotEmpty()) {
            map[str] = true
            str = str.dropLast(1)
        }
    }

    for (i in 0 until m) {
        val str = readln()

        if (map[str] != null) cnt++
    }

    println(cnt)
}