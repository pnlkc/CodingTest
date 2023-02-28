fun main() {
    for (i in 1..readln().toInt()) {
        val input = readln().split(" ").map { it.toInt() }
        println("Case #$i: ${input[0]} + ${input[1]} = ${input.sum()}")
    }
}