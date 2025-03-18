fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val (M, N) = readln().split(" ")

        if (M == "1") {
            sb.appendLine(N.split(".").joinToString("") {
                var temp = it.toInt().toString(2)

                while (temp.length != 8) {
                    temp = "0$temp"
                }

                temp
            }.toBigInteger(2))
        } else {
            val str = N.toBigInteger().toString(2)
            var idx = str.lastIndex
            val result = mutableListOf<Int>()
            var temp: String

            while (idx >= 0) {
                temp = ""

                for (i in 0..7) {
                    if (idx - i < 0) break

                    temp = str[idx - i] + temp
                }

                result.add(temp.toInt(2))
                idx -= 8
            }

            while (result.size < 8) {
                result.add(0)
            }

            sb.appendLine(result.reversed().joinToString("."))
        }
    }

    print(sb)
}