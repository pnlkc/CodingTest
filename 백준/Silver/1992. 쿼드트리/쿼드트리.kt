fun main() {
    val s = StringBuilder()
    val n = readln().toInt()
    val arr = Array(n) { readln() }
    calc(arr, n, 0, 0, s)
    println(s.toString())
}

fun calc(arr: Array<String>, n: Int, x: Int, y: Int, s: StringBuilder) {
    val exist = booleanArrayOf(false, false)

    p@ for (i in y until y + n) {
        for (j in x until x + n) {
            if (arr[i][j] == '0') exist[0] = true else exist[1] = true
            if (exist[0] && exist[1]) break@p
        }
    }

    when {
        exist[0] && exist[1] -> {
            s.append("(")
            calc(arr, n / 2, x, y, s)
            calc(arr, n / 2, x + n / 2, y, s)
            calc(arr, n / 2, x, y + n / 2, s)
            calc(arr, n / 2, x + n / 2, y + n / 2, s)
            s.append(")")
        }
        exist[0] -> s.append("0")
        exist[1] -> s.append("1")
    }
}