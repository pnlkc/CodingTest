data class Data(val name: String, val a: Int, val b: Int, val c: Int)

fun main() {
    val N = readln().toInt()
    val list = mutableListOf<Data>()

    for (i in 1..N) {
        val (name, a, b, c) = readln().split(" ")

        list.add(Data(name, a.toInt(), b.toInt(), c.toInt()))
    }

    list
        .sortWith(
            compareByDescending<Data> { it.a }
                .thenBy { it.b }
                .thenByDescending { it.c }
                .thenBy { it.name }
        )

    list.forEach { println(it.name) }
}