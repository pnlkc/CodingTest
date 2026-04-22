fun main() {
    var i = readLine()!!.toInt()
    repeat(i) {
        var a = readLine()
        println("${a!!.split(" ").first().toInt() + a!!.split(" ").last().toInt()}")
    }
}