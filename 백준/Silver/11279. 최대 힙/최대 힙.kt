import java.util.*

fun main() {
    val tcNum = readln().toInt()
    val pQueue = PriorityQueue<Int>(reverseOrder())
    
    repeat(tcNum) {
        when(val input = readln().toInt()) {
            0 -> {
                println(if (pQueue.isEmpty()) 0 else pQueue.poll())
            }
            else -> pQueue.add(input)
        }
    }
}