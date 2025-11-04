fun main() {
    val sb = StringBuilder()
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Boolean>()
    var num = n

    repeat(n) {
        map[readln()] = true
    }

    for (i in 0 until m) {
        val list = readln().split(",")

        list.forEach {
            if (map[it] != null && map[it] == true) {
                map[it] = false
                num--
            }
        }

        sb.appendLine(num)
    }

    print(sb)
}