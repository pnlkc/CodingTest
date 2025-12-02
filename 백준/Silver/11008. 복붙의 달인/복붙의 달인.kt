fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()

    repeat(t) {
        val (s, p) = readln().split(" ")
        var str = s
        var temp = s
        var result = 0

        do {
            str = temp
            temp = temp.replaceFirst(p, "")
            if (str.length != temp.length) result++
        } while (str.length != temp.length)

        sb.appendLine(result + temp.length)
    }

    print(sb)
}