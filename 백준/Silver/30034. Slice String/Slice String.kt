fun main() {
    val N = readln().toInt()
    val nL = readln().split(" ").toMutableList()
    val M = readln().toInt()
    val mL = readln().split(" ").toMutableList()
    val K = readln().toInt()
    val kL = readln().split(" ").toMutableList()
    val S = readln().toInt()
    val str = readln()

    nL.removeAll(kL)
    mL.removeAll(kL)
    nL.distinct()
    mL.distinct()

    println(str.split(" ", *nL.toTypedArray(), *mL.toTypedArray()).filter { it.isNotBlank() }.joinToString("\n"))
}