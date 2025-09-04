fun main() {
    val sb = StringBuilder()
    val M = readln().toInt()
    var three = 0L
    var four = 0L

    for (i in 0 until M) {
        val input = readln()

        when (input[0]) {
            '1' -> {
                val num = input.substring(2).toLong()

                three += num
                four = four.xor(num)
            }
            '2' -> {
                val num = input.substring(2).toLong()

                three -= num
                four = four.xor(num)
            }
            '3' -> sb.appendLine(three)
            '4' -> sb.appendLine(four)
        }
    }

    print(sb)
}