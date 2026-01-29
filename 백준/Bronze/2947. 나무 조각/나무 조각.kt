fun main() {
    val sb = StringBuilder()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()

    while (true) {
        var isEnd = true

        for (i in 0..3) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i + 1]

                arr[i + 1] = arr[i]
                arr[i] = temp
                isEnd = false
                sb.appendLine(arr.joinToString(" "))
            }
        }

        if (isEnd) break
    }

    print(sb)
}