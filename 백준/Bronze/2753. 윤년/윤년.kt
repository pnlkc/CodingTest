fun main() {
    var input = readLine()!!.toInt()
    when {
        input % 4 == 0 && input % 100 != 0  -> println("1")
        input % 400 == 0 -> println("1")
        else -> println("0")
    }
}