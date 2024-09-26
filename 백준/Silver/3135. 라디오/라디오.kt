import java.util.LinkedList

fun main() {
    val (A, B) = readln().split(" ").map { it.toInt() }
    val N = readln().toInt()
    val arr = IntArray(N)
    val dp = BooleanArray(1_000)

    for (i in 0 until N) {
        arr[i] = readln().toInt()
    }

    val q = LinkedList<Pair<Int, Int>>()
    q.add(A to 0)
    dp[A] = true

    while (q.isNotEmpty()) {
        val (cn, cc) = q.poll()!!

        if (cn == B) {
            println(cc)
            return
        }

        if (cn + 1 < 1000 && !dp[cn + 1]) {
            q.add(cn + 1 to cc + 1)
            dp[cn + 1] = true
        }

        if (cn - 1 >= 1 && !dp[cn - 1]) {
            q.add(cn - 1 to cc + 1)
            dp[cn - 1] = true
        }

        for (i in 0 until N) {
            if (!dp[arr[i]]) {
                q.add(arr[i] to cc + 1)
                dp[arr[i]] = true
            }
        }
    }
}