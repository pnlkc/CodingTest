fun main() {
    val (n, z, m) = readln().split(" ").map { it.toInt() }
    val arr = BooleanArray(n)

    readln().split(" ").map { it.toInt() }.forEach { arr[it - 1] = true }

    p@ for (i in 1 until n) {
        var num = 0
        val isVisit = arr.clone()

        while (true) {
            if (num == z - 1) break
            if (isVisit[num]) continue@p

            isVisit[num] = true
            num = (num + i) % n
        }

        println(i)
        return
    }
}