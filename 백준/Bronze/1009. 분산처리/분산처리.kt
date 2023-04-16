fun main() {
    val sb = StringBuilder()

    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        var num = 1
        for (i in 1..b) {
            num = if (num * a % 10 == 0) 10 else num * a % 10
        }
        sb.appendLine(num)
    }

    println(sb.toString())
}