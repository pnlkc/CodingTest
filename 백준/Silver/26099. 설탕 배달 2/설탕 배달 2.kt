fun main() {
    val n = readln().toLong()
    var result = Long.MAX_VALUE

    for (i in 0..4) {
        val num = n - i * 3

        if (num == 0L || (num > 0L && num % 5 == 0L)) {
            result = minOf(result, i + num / 5)
        }
    }

    println(if (result == Long.MAX_VALUE) -1 else result)
}