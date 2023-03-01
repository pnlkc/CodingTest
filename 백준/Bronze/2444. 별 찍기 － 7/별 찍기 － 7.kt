fun main() {
    val num = readln().toInt()
    var center = ""
    repeat(1 + (num - 1) * 2) {
        center += "*"
    }
    val list = mutableListOf<String>()
    for (i in 1 until num) {
        var string = ""
        repeat(1 + 2*(i - 1)) { string += "*" }

        var surround = ""
        val targetLength = 1 + (num - 1) * 2
        repeat((targetLength - string.length) / 2) {
            surround += " "
        }

        list.add(surround + string)
    }

    list.forEach { println(it) }
    println(center)
    list.reversed().forEach { println(it) }
}