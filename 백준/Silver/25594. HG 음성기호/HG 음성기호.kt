fun main() {
    val sb = StringBuilder()
    val temp = StringBuilder()
    val map = mutableMapOf(
        "aespa" to "a",
        "baekjoon" to "b",
        "cau" to "c",
        "debug" to "d",
        "edge" to "e",
        "firefox" to "f",
        "golang" to "g",
        "haegang" to "h",
        "iu" to "i",
        "java" to "j",
        "kotlin" to "k",
        "lol" to "l",
        "mips" to "m",
        "null" to "n",
        "os" to "o",
        "python" to "p",
        "query" to "q",
        "roka" to "r",
        "solvedac" to "s",
        "tod" to "t",
        "unix" to "u",
        "virus" to "v",
        "whale" to "w",
        "xcode" to "x",
        "yahoo" to "y",
        "zebra" to "z"
    )
    val str = readln()

    for (i in str.indices) {
        temp.append(str[i])

        val result = temp.toString()

        if (map[result] != null) {
            sb.append(map[result])
            temp.clear()
        } else if (temp.length > 8) {
            println("ERROR!")
            return
        }
    }

    println(if (temp.isNotEmpty()) "ERROR!" else "It's HG!\n$sb")
}