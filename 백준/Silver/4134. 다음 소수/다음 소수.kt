fun main() {
    val tcNum = readln().toInt()
    repeat(tcNum) {
        var input = maxOf(readln().toLong(), 2)

        p@while (true) {
            for (i in 2..input) {
                if (i * i > input) {
                    println(input)
                    break@p
                }
                
                if (input % i == 0L) {
                    input++
                    continue@p
                }
            }
        }
    }
}