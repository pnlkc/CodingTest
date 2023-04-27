import java.util.Stack

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n)
    val stack = Stack<IntArray>()
    var r = 0L

    (0 until n).forEach { arr[it] = readln().toInt() }
    stack.push(intArrayOf(arr[0], 1))

    for (i in 1 until n) {
        val temp = intArrayOf(arr[i], 1)

        while (stack.isNotEmpty() && stack.peek()[0] <= temp[0]) {
            val c = stack.pop()
            r += c[1]
            if (c[0] == temp[0]) temp[1] += c[1]
        }

        if (stack.isNotEmpty()) r++
        stack.push(temp)
    }

    println(r)
}