fun main() {
    val N = readln().toInt()
    val arr = BooleanArray(N + 1)
    val result = IntArray(N)
    var n = 2

    result[0] = 1

    for (i in 2.. N) {
        var num = i
        var isChange = false

        while (num <= N) {
            if (!arr[num]) {
                result[num - 1] = n
                arr[num] = true
                isChange = true
            }

            num += i
        }

        if (isChange) n++
    }

    println(n -1)
    println(result.joinToString(" "))
}