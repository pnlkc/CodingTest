fun main() {
    val (a, b) = readln().split(" ")
    var aIdx = a.lastIndex
    var bIdx = b.lastIndex
    var result = ""

    while (aIdx >= 0 || bIdx >= 0) {
        val tA = if (aIdx >= 0) a[aIdx--].digitToInt() else 0
        val tB = if (bIdx >= 0) b[bIdx--].digitToInt() else 0

        result = (tA + tB).toString() + result
    }

    println(result)
}