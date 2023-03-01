fun main() {
    val size = readln()
    val list = readln().split(" ")
    val target = readln()
    println(list.count { it == target })
}
