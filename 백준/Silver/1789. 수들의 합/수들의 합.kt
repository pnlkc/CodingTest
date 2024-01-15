fun main() {
    val num = readln().toLong()
    for (i in 0..Int.MAX_VALUE) {
        if (i.toLong() * (i + 1) / 2 > num) {
            println(i - 1)
            return
        }
    }
}