fun main() {
    val inputList = readLine()!!.split(" ").map { it.toLong() }
    println(inputList.sum().toString())
}