fun main() {
    val result = mutableListOf<Long>()
    var isFirst = false

    while (true) {
        val input = readlnOrNull() ?: break
        val list = input.split(" ")

        for (numStr in list) {
            if (!isFirst) {
                isFirst = true
                continue
            }

            if (numStr.isNotEmpty()) {
                result.add(numStr.reversed().toLong())
            }
        }
    }

    println(result.sorted().joinToString("\n"))
}