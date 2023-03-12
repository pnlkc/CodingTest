fun main() {
    val tcNum = readln().toInt()

    repeat(tcNum) {
        var (a, b) = readln().split(" ").map { it.toInt() }
        var div = 1

        while (true) {
            var isEnd = true
            for (i in 2..minOf(a, b)) {
                if (a % i == 0 && b % i == 0) {
                    div *= i
                    a /= i
                    b /= i
                    isEnd = false
                    break
                }
            }
            if (isEnd) break
        }

        println(div * a * b)
    }
}