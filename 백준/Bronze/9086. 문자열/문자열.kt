fun main() {
    val num = readln().toInt()
    repeat(num) {
        val string = readln()
        println("${string.first()}${string.last()}")
    }
} 