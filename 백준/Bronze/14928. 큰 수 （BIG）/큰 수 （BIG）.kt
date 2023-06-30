fun main() {
    val n = readln()
    val num = 20_000_303
    var remainder = 0

    for (i in n.indices) {
        remainder = (remainder * 10 + n[i].digitToInt()) % num
    }

    println(remainder)
}