fun main() {
    val n = readln()
    val f = readln().toInt()
    var num = n.toInt() - n.slice(n.lastIndex - 1..n.lastIndex).toInt()
    for (i in num..num + 99) {
        if (i % f == 0) {
            println(i.toString().slice(n.lastIndex - 1..n.lastIndex))
            break
        }
    }
}