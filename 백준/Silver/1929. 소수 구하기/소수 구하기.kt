fun main() {
    val (s, e) = readln().split(" ").map { it.toInt() }
    p@for (i in s..e) {
        if (i < 1) continue
        for (j in 2..i) {
            if (j * j > i) {
                println(i)
                continue@p
            }

            if (i % j == 0) continue@p
        }
    }
}