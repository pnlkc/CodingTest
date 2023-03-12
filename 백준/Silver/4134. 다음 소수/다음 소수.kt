fun main() {
    val tcNum = readln().toInt()
    repeat(tcNum) {
        var input = maxOf(readln().toLong(), 2)

        while (true) {
            var result = true
            for (i in 2..input) {
                if (i * i > input) break
                if (input % i == 0L) {
                    result = false
                    break
                }
            }
            if (result) {
                println(input)
                break
            } else {
                input++
            }
        }
    }
}