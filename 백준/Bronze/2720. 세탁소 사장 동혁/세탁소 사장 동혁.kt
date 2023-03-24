fun main() {
    repeat(readln().toInt()) {
        var answer = ""
        var num = readln().toInt()

        val calc: (Int) -> Unit = { n ->
            answer += if (n != 25) " " + num / n else num / n
            num %= n
        }

        calc(25)
        calc(10)
        calc(5)
        calc(1)

        println(answer)
    }
}