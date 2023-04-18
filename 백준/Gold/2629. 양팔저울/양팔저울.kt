fun main() {
    val n1 = readln().toInt()
    val arr1 = readln().split(" ").map { it.toInt() }
    val n2 = readln().toInt()
    val arr2 = readln().split(" ").map { it.toInt() }
    var ms = mutableSetOf<Int>()
    val answer = mutableListOf<String>()

    for (i in 0 until n1) {
        val nms = mutableSetOf<Int>()
        ms.forEach {
            nms.add(it)
            nms.add(it + arr1[i])
            nms.add(it - arr1[i])
        }
        nms.add(arr1[i])
        nms.add(-arr1[i])
        ms = nms
    }

    arr2.forEach { answer.add(if (ms.contains(it)) "Y" else "N") }

    println(answer.joinToString(" "))
}