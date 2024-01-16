fun main() {
    val n = readln().toInt()
    var cnt = 0

    p@ for (i in 1..n) {
        if (i > 99) {
            val str = i.toString()

            val diff = str[0] - str[1]

            for (j in 0 until str.lastIndex) {
                if (diff != str[j] - str[j + 1]) continue@p
            }
        }

        cnt++
    }

    println(cnt)
}