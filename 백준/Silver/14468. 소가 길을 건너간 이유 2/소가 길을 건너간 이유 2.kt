fun main() {
    val str = readln()
    val sMap = mutableMapOf<Char, Int>()
    val eMap = mutableMapOf<Char, Int>()
    var cnt = 0

    for (i in str.indices) {
        if (sMap[str[i]] == null) {
            sMap[str[i]] = i
        } else {
            eMap[str[i]] = i
        }
    }

    for (c1 in 'A'..'Z') {
        for (c2 in 'A'..'Z') {
            if (c1 == c2) continue

            if (sMap[c1]!! < sMap[c2]!! && sMap[c2]!! < eMap[c1]!! && eMap[c1]!! < eMap[c2]!!) cnt++
        }
    }

    println(cnt)
}