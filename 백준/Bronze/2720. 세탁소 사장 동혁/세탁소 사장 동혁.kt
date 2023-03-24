fun main() {
    repeat(readln().toInt()) {
        val answer = mutableListOf<Int>()
        var num = readln().toInt()

        val calc: (Int) -> Unit = { n ->
            answer.add(num / n)
            num %= n
        }

        calc(25)
        calc(10)
        calc(5)
        calc(1)

        println(answer.joinToString(" "))
    }
}