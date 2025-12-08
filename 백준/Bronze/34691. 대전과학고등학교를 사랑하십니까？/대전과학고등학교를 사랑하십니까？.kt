fun main() {
    val sb = StringBuilder()

    while (true) {
        val input = readln()

        when (input) {
            "animal" -> sb.appendLine("Panthera tigris")
            "tree" -> sb.appendLine("Pinus densiflora")
            "flower" -> sb.appendLine("Forsythia koreana")
            "end" -> break
        }
    }

    print(sb)
}