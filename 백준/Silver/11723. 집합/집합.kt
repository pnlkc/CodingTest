fun main() {
    val sb = StringBuilder()
    var set = mutableSetOf<Int>()

    repeat(readln().toInt()) {
        val input = readln().split(" ")

        when (input[0]) {
            "add" -> set.add(input[1].toInt())
            "remove" -> set.remove(input[1].toInt())
            "check" -> set.contains(input[1].toInt()).also { sb.appendLine(if (it) 1 else 0) }
            "toggle" -> {
                set
                    .contains(input[1].toInt())
                    .also { if (it) set.remove(input[1].toInt()) else set.add(input[1].toInt()) }
            }
            "all" -> set = (1..20).toMutableSet()
            "empty" -> set.clear()
        }
    }

    println(sb.toString())
}