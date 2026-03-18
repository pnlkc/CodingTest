data class Data(val name: String, val len: Double)

fun main() {
    val sb = StringBuilder()

    while (true) {
        val n = readln().toInt()

        if (n == 0) break

        val arr = Array(n) { Data("", 0.0) }

        for (i in 0 until n) {
            val (name, len) = readln().split(" ")

            arr[i] = Data(name, len.toDouble())
        }

        arr.sortByDescending { it.len }
        arr.filter { it.len == arr[0].len }.forEachIndexed { idx, data ->
            if (idx != 0) sb.append(" ")
            sb.append(data.name)
        }
        sb.appendLine()
    }

    print(sb)
}