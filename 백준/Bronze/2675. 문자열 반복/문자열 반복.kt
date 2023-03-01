fun main() {
    val num = readln().toInt()
    repeat(num) {
        val input = readln().split(" ")
        println(input[1].fold("") { acc, c -> acc + c.toString().repeat(input[0].toInt()) })
    }
}