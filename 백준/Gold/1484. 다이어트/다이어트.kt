fun main() {
    val sb = StringBuilder()
    val G = readln().toInt()
    var s = 1
    var e = 1

    while (s <= e) {
        if (e - 1 == s && e * e - s * s > 100_000) break

        when {
            e * e - s * s < G -> e++
            e * e - s * s > G -> s++
            else -> {
                sb.append(e).append("\n")
                e++
            }
        }
    }

    print(sb.ifEmpty { -1 })
}