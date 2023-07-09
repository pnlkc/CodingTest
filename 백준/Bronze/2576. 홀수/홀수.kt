fun main() {
    val mList = mutableListOf<Int>()
    repeat(7) {
        mList.add(readln().toInt())
    }
    val fList = mList.filter { it % 2 == 1 }
    if (fList.isEmpty()) {
        println(-1)
    } else {
        println(fList.sum())
        println(fList.sorted()[0])
    }
}