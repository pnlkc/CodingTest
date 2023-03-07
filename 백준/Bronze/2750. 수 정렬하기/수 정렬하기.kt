import java.util.*

fun main() {
    val testCaseNum = readln().toInt()
    val list = PriorityQueue<Int>()

    repeat(testCaseNum) {
        list.add(readln().toInt())
    }
    
    while (list.isNotEmpty()) {
        println(list.poll()!!)
    }
}