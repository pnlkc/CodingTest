fun main() {
    var a = readLine()
    var int1 = a!!.split(" ")[0].toInt()
    var int2 = a.split(" ")[1].toInt()
    when {
        int1 > int2 -> println(">")
        int1 < int2 -> println("<")
        else -> println("==")
    }
}