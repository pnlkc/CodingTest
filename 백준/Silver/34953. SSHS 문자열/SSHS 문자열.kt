fun main() {
    val n = readln().toInt()
    val str = "SSH"
    val sb = StringBuilder()
    var idx = 0

    for (i in 0 until n) {
        sb.append(str[idx])
        idx = (idx + 1) % 3
    }

    print(sb)
}