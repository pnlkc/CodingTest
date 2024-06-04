import java.util.PriorityQueue

fun main() {
    val N = readln().toInt()
    var list = mutableListOf<Data>()
    val roomList = PriorityQueue<Data> { a, b -> a.e - b.e }

    for (i in 1..N) {
        val (n, s, e) = readln().split(" ").map { it.toInt() }
        list.add(Data(n, s, e))
    }

    list = list.sortedWith(compareBy<Data> { it.s }.thenBy { it.e }).toMutableList()

    for ((n, s, e) in list) {
        if (roomList.isEmpty()) {
            roomList.offer(Data(n, s, e))
        } else {
            if (roomList.peek()!!.e <= s) {
                roomList.poll()
                roomList.offer(Data(n, s, e))
            } else {
                roomList.offer(Data(n, s, e))
            }
        }
    }

    println(roomList.size)
}

data class Data(val n: Int, val s: Int, val e: Int)