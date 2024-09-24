fun main() {
    val sb = StringBuilder()
    val MAX = 1_000_000
    val list = mutableListOf<Int>()
    var num = 1
    val arr = BooleanArray(10)

    p@while (true) {
        var temp = num
        
        arr.fill(false)

        while (temp > 0) {
            if (arr[temp % 10]) {
                num++
                continue@p
            }

            arr[temp % 10] = true
            temp /= 10
        }

        list.add(num)
        num++

        if (list.size > MAX) break
    }

    while (true) {
        val n = readln().toInt()
        if (n == 0) break

        sb.appendLine(list[n - 1])
    }

    print(sb)
}