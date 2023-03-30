fun main() {
    val s = readln()
    val num = readln().toInt()
    val map = mutableMapOf<String, IntArray>()

    repeat(num) {
        val (c, l, r) = readln().split(" ")

        if (map[c] == null) {
            map[c] = IntArray(s.length + 1)
            for (i in 1..s.length) {
                map[c]!![i] = map[c]!![i - 1] + if (s[i - 1].toString() == c) 1 else 0
            }
        }

        println(map[c]!![r.toInt() + 1] - map[c]!![l.toInt()])
    }
}