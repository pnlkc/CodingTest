fun main() {
    val testCaseNum = readln().toInt()
    val list = mutableListOf<String>()
    val ranking = IntArray(testCaseNum) { 1 }

    repeat(testCaseNum) {
        list.add(readln())
    }

    for (i in list.indices) {
        for (j in list.indices) {
            val (ix, iy) = list[i].split(" ").map { it.toInt() }
            val (jx, jy) = list[j].split(" ").map { it.toInt() }
            if (ix < jx && iy < jy) ranking[i]++
        }
    }

    println(list.mapIndexed { index, _ ->  ranking[index] }.joinToString(" "))
}