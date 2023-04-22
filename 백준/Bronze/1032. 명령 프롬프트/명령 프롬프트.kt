fun main() {
    val n = readln().toInt()
    val answer = readln().toCharArray()

    repeat(n - 1) {
        val input = readln()
        for (i in answer.indices) {
            if (answer[i] != input[i]) answer[i] = '?'
        }
    }

    println(answer.joinToString(""))
}