fun main() {
    var str = ""

    while (true) {
        val input = readln()

        str += input

        if (input.contains("E-N-D")) {
            str.replace("E-N-D", "")
            break
        }
    }

    val list = str
        .map {
            if (it in 'a'..'z' || it in 'A'..'Z' || it == '-') it else " "
        }
        .joinToString("")
        .split(" ")

    var maxLen = 0
    var answer = ""

    for (i in list.indices) {
        if (list[i].length > maxLen) {
            maxLen = list[i].length
            answer = list[i]
        }
    }

    println(answer.lowercase())
}