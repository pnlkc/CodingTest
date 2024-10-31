fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    p1@ for (tc in 1..T) {
        val input = readln().toInt()

        p2@ for (i in 2..64) {
            var num = input
            val list = mutableListOf<Int>()

            while (num != 0) {
                list.add(num % i)
                num /= i
            }

            for (j in 0 until list.size / 2) {
                if (list[j] != list[list.lastIndex - j]) {
                    continue@p2
                }
            }

            sb.appendLine(1)
            continue@p1
        }

        sb.appendLine(0)
    }

    print(sb)
}