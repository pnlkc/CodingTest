fun main() {
    var a = readLine()!!.toInt()
    var b = 0
    for (i in 1..a) {
        b += i
    }
    println(b)
}