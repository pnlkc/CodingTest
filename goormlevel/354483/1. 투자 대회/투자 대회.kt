fun main(args: Array<String>) {
    val N = readLine()!!.toInt();
    val list = readLine()!!.split(" ").map { it.toInt() }
    var result = 0
    var prev = list.last()


    for (i in N - 2 downTo 0) {
        if (list[i] < prev) result += prev - list[i]
        prev = list[i]
    }

    println(result)
}