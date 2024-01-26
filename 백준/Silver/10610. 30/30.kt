fun main() {
    val str = readln()
    var num = 0

    for (i in str.indices) {
        num += str[i].digitToInt()
    }

    if (num % 3 != 0) {
        println(-1)
        return
    }

    val result = str
        .toCharArray()
        .map { it.digitToInt() }
        .sortedDescending()
        .joinToString("")

    if (result.last() != '0') {
        println(-1)
        return
    }

    println(result)
}