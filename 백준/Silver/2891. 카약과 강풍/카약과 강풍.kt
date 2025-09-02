import kotlin.collections.sorted

fun main() {
    val (N, S, R) = readln().split(" ").map { it.toInt() }
    val arr = BooleanArray(N) { true }
    val sL = readln().split(" ").map { it.toInt() - 1 }.sorted()
    val rL = readln().split(" ").map { it.toInt() - 1 }.sorted().toMutableList()

    for (i in 0 until S) {
        arr[sL[i]] = false

        if (rL.contains(sL[i])) {
            arr[sL[i]] = true
            rL.remove(sL[i])
        }
    }

    for (i in rL.indices) {
        val idx = rL[i]

        if (!arr[idx]) {
            arr[idx] = true
            continue
        }

        if (idx - 1 >= 0 && !arr[idx - 1]) {
            arr[idx - 1] = true
            continue
        }

        if (idx + 1 < N && !arr[idx + 1]) {
            arr[idx + 1] = true
        }
    }

    println(arr.count { !it })
}