fun main() {
    readln()
    val input = readln().split(" ").map { it.toInt() }
    println(
        input.count { num ->
            var count = 0
            for (i in 1..num) {
                if (num % i == 0) count++
                if (count > 2) break
            }
            num != 1 && count == 2
        }
    )
}