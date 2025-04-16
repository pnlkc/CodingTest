fun main() {
    val sb = StringBuilder()
    val T = readln().toInt()

    for (tc in 1..T) {
        val input = readln().toCharArray()
        val num = input.map { it.digitToInt() }.toIntArray()
        var cnt = 0

        while (!(num[0] == 6 && num[1] == 1 && num[2] == 7 && num[3] == 4)) {
            var max = 0
            var min = 0

            num.sort()

            for (i in 0..3) {
                var tempMax = 1
                var tempMin = 1

                repeat(i) {
                    tempMax *= 10
                }

                repeat(3 - i) {
                    tempMin *= 10
                }

                max += num[i] * tempMax
                min += num[i] * tempMin
            }

            var diff = max - min

            for (i in 1..4) {
                num[4 - i] = diff % 10
                diff /= 10
            }


            cnt++
        }

        sb.appendLine(cnt)
    }

    print(sb)
}