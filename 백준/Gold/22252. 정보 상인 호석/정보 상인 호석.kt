import java.util.PriorityQueue
import java.util.StringTokenizer

fun StringTokenizer.ni() = this.nextToken().toInt()

fun main() {
    val Q = readln().toInt()
    var st: StringTokenizer
    val map = mutableMapOf<String, PriorityQueue<Int>>()
    var result = 0L

    for (i in 0 until Q) {
        st = StringTokenizer(readln())
        val command = st.ni()
        val name = st.nextToken()

        if (command == 1) {
            if (map[name] == null) map[name] = PriorityQueue<Int>(Comparator.reverseOrder<Int>())

            repeat(st.ni()) {
                map[name]!!.add(st.ni())
            }
        } else {
            for (i in 0 until st.ni()) {
                if (map[name] == null || map[name]!!.isEmpty()) break
                
                result += map[name]!!.poll()!!
            }
        }
    }

    println(result)
}