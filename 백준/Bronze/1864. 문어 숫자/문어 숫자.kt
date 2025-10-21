fun main() {
    val map = mutableMapOf(
        '-' to 0, '\\' to 1, '(' to 2, '@' to 3, '?' to 4, '>' to 5, '&' to 6, '%' to 7, '/' to -1
    )

    while (true) {
        val input = readln()
        
        if (input == "#") break
        
        var result = 0
        var num = 1

        for (i in input.indices) {
            result += map[input[input.lastIndex - i]]!! * num
            num *= 8
        }

        println(result)
    }
}