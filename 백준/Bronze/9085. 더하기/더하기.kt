fun main() {
    val t = readln().toInt()

    repeat(t) {
        val n = readln()

        println(readln().split(" ").map { it.toInt() }.sum())
    }
}