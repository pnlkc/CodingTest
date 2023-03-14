fun main() {
    val tcNum = readln().toInt()
    repeat(tcNum) {
        val l = readln().split(" ").map { it.toInt() }
        val dist = (l[3] - l[0]) * (l[3] - l[0]) + (l[4] - l[1]) * (l[4] - l[1])
        val r3 = (l[2] + l[5]) * (l[2] + l[5])
        val r4 = (l[2] - l[5]) * (l[2] - l[5])
        println(
            when {
                l[0] == l[3] && l[1] == l[4] && l[2] == l[5] -> -1
                r3 == dist || r4 == dist -> 1
                dist in (r4 + 1) until r3 -> 2
                else -> 0
            }
        )
    }
}