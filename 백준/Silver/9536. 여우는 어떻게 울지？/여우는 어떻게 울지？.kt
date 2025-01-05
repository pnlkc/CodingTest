fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val list = readln().split(" ").toMutableList()

        while (true) {
            val input = readln()

            if (input == "what does the fox say?") break

            val (a, b, c) = input.split(" ")
            if (a != "fox") {
                while (list.contains(c)) {
                    list.remove(c)
                }
            }
        }

        sb.appendLine(list.joinToString(" "))
    }

    print(sb)
}