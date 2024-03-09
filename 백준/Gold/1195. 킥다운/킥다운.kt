fun main() {
    val a = readln()
    val b = readln()
    var min = a.length + b.length

    var s = -b.length

    p@ for (i in -b.length..a.length) {
        var cnt = a.length + b.length

        for (j in b.indices) {
            if (i + j < 0) continue
            if (i + j < a.length && a[i + j].digitToInt() + b[j].digitToInt() > 3) continue@p
            if (i + j < a.length) cnt--
        }

        min = minOf(min, cnt)
    }

    println(min)
}