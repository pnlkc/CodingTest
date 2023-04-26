fun main(args: Array<String>) {
    readln().toInt().run { println(if (this % 2 == 0) "$this is even" else "$this is odd") }
}