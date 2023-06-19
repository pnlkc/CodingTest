fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val mList = mutableListOf<String>()
    val list = readln().split(' ').map(String::toInt).sorted()
    calc(list, mList, mutableListOf(), m)
    mList.forEach { println(it) }
}

fun calc(list: List<Int>, mList: MutableList<String>, used: MutableList<Int>, m: Int) {
    if (used.size == m) {
        mList.add(used.map { list[it] }.joinToString(" "))
    } else if (used.size < m) {
        for (i in list.indices) {
            if (!used.contains(i)) {
                used.add(i)
                calc(list, mList, used, m)
                used.removeLast()
            }
        }
    }
}