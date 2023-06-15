fun main() {
    var count = 0
    val nL = readln().toInt()
    val n = "I" + "OI".repeat(nL)
    val sL = readln().toInt()
    val s = readln()

    p@ for (i in 0..sL - n.length) {
        for (j in n.indices) {
            if (s[i + j] != n[j]) continue@p
        }
        count++
    }

    println(count)
}