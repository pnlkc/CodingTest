fun main() {
    val list = mutableListOf<Long>(0, 1, 1)
    val n = readln().toInt()

    while(list.size <= n) {
        val lastIdx = list.lastIndex

        list.add(list[lastIdx] + list[lastIdx - 1])
    }

    println(list[n])
}