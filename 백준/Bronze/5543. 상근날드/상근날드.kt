fun main() {
    val aL = intArrayOf(readln().toInt(), readln().toInt(), readln().toInt())
    val bL = intArrayOf(readln().toInt(), readln().toInt())

    println(aL.min() + bL.min() - 50)
}