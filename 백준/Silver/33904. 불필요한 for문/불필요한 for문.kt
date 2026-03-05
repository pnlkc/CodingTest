import java.util.LinkedList

fun main() {
    val sb = StringBuilder()
    var space = ""
    val q = LinkedList<Char>()
    val strQ = LinkedList<String>()
    val cnt = mutableMapOf<Char, Int>()

    while (true) {
        val input = readlnOrNull() ?: break
        
        if (input.isEmpty()) break
        
        val str = input.trim()

        if (str.startsWith("for")) {
            val c = str[9]

            q.add(c)
            strQ.add(str)
            cnt[c] = if (cnt[c] == null) 1 else cnt[c]!! + 1
        } else {
            while (q.isNotEmpty()) {
                val c = q.pollFirst()!!
                val cStr = strQ.pollFirst()!!

                if (cnt[c] != 1) {
                    cnt[c] = cnt[c]!! - 1
                    continue
                }

                if (!str.contains(c)) continue

                sb.appendLine(space + cStr)
                space += " "
            }

            sb.appendLine(space + str)
        }
    }

    print(sb)
}