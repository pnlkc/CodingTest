fun main() {
    val T = readln().toInt()
    val sb = StringBuilder()
    val NUM = 100_000
    val pArr = BooleanArray(NUM + 1) { true }
    val pL = mutableListOf<Int>()

    for (i in 2..NUM) {
        if (!pArr[i]) continue

        var num = i * 2

        while (num <= NUM) {
            pArr[num] = false
            num += i
        }
    }

    for (i in 2..NUM) {
        if (pArr[i]) pL.add(i)
    }

    for (tc in 1..T) {
        var N = readln().toInt()
        val map = mutableMapOf<Int, Int>()

        for (num in pL) {
            while (N % num == 0) {
                if (map[num] == null) map[num] = 1 else map[num] = map[num]!! + 1
                N /= num
            }
        }

        for (key in map.keys.sorted()) {
            sb.appendLine("$key ${map[key]}")
        }
    }

    print(sb)
}