import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val set = mutableSetOf<String>()

    for (i in 0 until n) {
        val str = st.nextToken()

        if (str.endsWith("Cheese")) {
            set.add(str)

            if (set.size >= 4) {
                println("yummy")
                return
            }
        }
    }

    println("sad")
}