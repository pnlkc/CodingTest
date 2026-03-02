fun main() {
    val sb = StringBuilder()
    val t = readln().toInt()

    for (tc in 1..t) {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val arr = readln().split(" ")
        val cnt = mutableMapOf<String, Int>()
        var answer = 0

        for (str in arr) {
            val result = IntArray(28)
            val lowerCase = str.lowercase()

            for (c in 'a'..'z') {
                result[c - 'a'] = lowerCase.count { it == c }
            }

            result[26] = str.count { it in 'a'..'z' }
            result[27] = str.length - result[26]

            val key = result.joinToString("")

            cnt[key] = if (cnt[key] == null) 1 else cnt[key]!! + 1
        }

        for ((_, value) in cnt) {
            for (i in value - 1 downTo 1) {
                answer += i
            }
        }

        sb.appendLine(answer)
    }

    print(sb)
}