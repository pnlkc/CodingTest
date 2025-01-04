fun main() {
    val K = readln().toInt() + 1
    val str = K.toString(2)
    val sb = StringBuilder()

    for (i in 1 until str.length) {
        sb.append(if (str[i] == '1') "7" else "4")
    }

    println(sb)
}