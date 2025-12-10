fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var a = list[0]
    var b = list[n - 1]

    for (i in n - 2 downTo 1) {
        if (i == 1) {
            a--
            b--
        } else {
            if (a < b) b-- else a--
        }
    }

    println(maxOf(a, b))
}