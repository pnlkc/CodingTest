fun main() {
    val sb = StringBuilder()
    val tc = readln().toInt()
    val arr = Array(12) { mutableSetOf<String>() }
    arr[0].add("")

    val answer = makeArr(arr)

    repeat(tc) {
        val n = readln().toInt()
        sb.appendLine(answer[n])
    }

    println(sb)
}

fun makeArr(arr: Array<MutableSet<String>>): IntArray {
    for (i in arr.indices) {
        arr[i].forEach { s ->
            val sum = s.map { it.digitToInt() }.sum()

            for (j in 1..3) {
                if (i + j <= arr.lastIndex && sum + j <= i + j) {
                    arr[i + j].add(s + "$j")
                    arr[i + j].add("$j" + s)
                }
            }
        }
    }

    return arr.map { it.size }.toIntArray()
}