fun main() {
    var num = 0

    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        num += b % a
    }

    println(num)
}
