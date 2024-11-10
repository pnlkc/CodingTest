fun main() {
    val money = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var a = money
    var aCnt = 0
    var b = money
    var bCnt = 0

    for (i in 0 until 14) {
        aCnt += a / list[i]
        a %= list[i]
    }

    a += aCnt * list[13]

    for (i in 3 until 14) {
        if (list[i - 3] < list[i - 2] && list[i - 2] < list[i - 1]) {
            b += bCnt * list[i]
            bCnt = 0
        }

        if (list[i - 3] > list[i - 2] && list[i - 2] > list[i - 1]) {
            bCnt += b / list[i]
            b %= list[i]
        }
    }

    b += bCnt * list[13]

    println(if (a > b) "BNP" else if (a < b) "TIMING" else "SAMESAME")
}