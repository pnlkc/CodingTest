fun main() {
    val N = readln().toInt()
    val list = mutableListOf<Int>()

    if (N % 2 == 0) {
        for (i in N / 2 downTo 1) {
            list.add(i)
            list.add(i + N / 2)
        }
    } else {
        for (i in 1..N / 2) {
            list.add(i)
            list.add(i + N / 2 + 1)
        }

        list.add(N / 2 + 1)
    }

    println(list.joinToString(" "))
}