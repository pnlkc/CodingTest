fun main() {
    val sb = StringBuilder()
    val map = mutableMapOf(
        "@" to "a",
        "[" to "c",
        "!" to "i",
        ";" to "j",
        "^" to "n",
        "0" to "o",
        "7" to "t",
        "\\\\'" to "w",
        "\\'" to "v",
    )
    val n = readln().toInt()

    p@ for (i in 0 until n) {
        var str = readln()
        var cnt = 0

        map.forEach { (k, v) ->
            while (str.contains(k)) {
                str = str.replaceFirst(k, v)
                cnt++
            }
        }

        for (it in str) {
            if (it !in 'a'..'z') {
                sb.appendLine("I don't understand")
                continue@p
            }
        }

        val len = str.length / 2 + if (str.length % 2 != 0) 1 else 0

        sb.appendLine(if (len <= cnt) "I don't understand" else str)
    }

    print(sb)
}