fun main() {
    val map = ('a'..'z').zip(1..26).toMap()
    val n = readln().toInt()
    val s = readln()
    var r = 0L

    s.forEachIndexed { idx, c ->
        var ri = 1L
        for (i in 1..idx) {
            ri = ri * 31 % 1234567891
        }
        r = (r + map[c]!! * ri) % 1234567891
    }

    println(r)
}