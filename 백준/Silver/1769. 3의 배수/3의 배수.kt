fun main() {
    var X = readln()
    var cnt = 0

    while (X.length > 1) {
        var temp = 0

        for (i in X.indices) {


            temp += X[i].digitToInt()
        }

        X = temp.toString()
        cnt++
    }

    println(cnt)
    println(if (X.toInt() % 3 == 0) "YES" else "NO")
}