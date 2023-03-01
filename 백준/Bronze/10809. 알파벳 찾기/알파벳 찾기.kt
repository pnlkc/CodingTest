fun main() {
    val string = readln()
    val list = ('a'..'z').map { c -> string.indexOfFirst { it == c } }
    println(list.joinToString(" "))
}