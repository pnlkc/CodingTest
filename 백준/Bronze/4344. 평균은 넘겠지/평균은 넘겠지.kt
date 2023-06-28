fun main() {
    val testNum = readln().toInt()

    repeat(testNum) {
        val input = readln().split(" ").map { it.toInt() }
        val list = input.slice(1..input.lastIndex)
        val sum = list.sum()
        val count = list.count { it * list.size > sum }
        var result = count * 1_000_000 / list.size
        if (result % 10 >= 5) result += 10
        val answer = ((result / 10).toDouble() / 1_000).toString().split('.')
        var back = answer[1]
        repeat(3 - answer[1].length) {
            back += "0"
        }
        println(answer[0] + "." + back + "%")
    }
}