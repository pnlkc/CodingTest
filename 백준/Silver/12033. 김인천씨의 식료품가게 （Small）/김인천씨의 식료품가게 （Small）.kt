fun main() {
    val sb = StringBuilder()

    for (t in 1..readln().toInt()) {
        val n = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }
        val map = mutableMapOf<Int, Int>()
        val result = mutableListOf<Int>()

        for (i in 0 until n * 2) {
            if (map[list[i]] != null && map[list[i]]!! > 0) {
                map[list[i]] = map[list[i]]!! - 1
                continue
            }

            val ori = list[i] / 3 * 4

            map[ori] = map.getOrDefault(ori, 0) + 1
            result.add(list[i])
        }

        sb.appendLine("Case #$t: ${result.joinToString(" ")}")
    }

    print(sb)
}