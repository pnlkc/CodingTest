fun main() {
    var input1 = readLine()!!.toInt()
    var input2 = readLine()!!.toInt()
    when {
        input1 > 0 && input2 > 0 -> println("1")
        input1 < 0 && input2 > 0 -> println("2")
        input1 < 0 && input2 < 0 -> println("3")
        input1 > 0 && input2 < 0 -> println("4")
    }
}