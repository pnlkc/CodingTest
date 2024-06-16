import java.util.PriorityQueue

fun main() {
    val N = readln().toInt()
    var list = mutableListOf<Data>()
    val roomList = PriorityQueue<Data> { a, b -> a.e - b.e }

    for (i in 1..N) {
        list.add(readln().split(" ").map { it.toInt() }.let { Data(it[0], it[1]) })
    }

    list = list.sortedWith(compareBy<Data> { it.s }.thenBy { it.e }).toMutableList()

    for ((s, e) in list) {
        if (roomList.isNotEmpty() && roomList.peek()!!.e <= s) roomList.poll()
        roomList.offer(Data(s, e))
    }

    println(roomList.size)
}

data class Data(val s: Int, val e: Int)