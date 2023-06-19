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
                val temp = used.toMutableList()
                temp.add(i)
                calc(list, mList, temp, m)
            }
        }
    }
}