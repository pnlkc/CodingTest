fun main() {
    val string = StringBuilder()
    val s = readln()
    val num = readln().toInt()
    val arr = Array(s.length + 1) { IntArray(26) }
    val exist = s.toSet()
    val aCode = 'a'.code

    s.forEachIndexed { idx, c ->
        exist.forEach {
            if (it == c) arr[idx + 1][it.code - aCode] = arr[idx][it.code - aCode] + 1
            else arr[idx + 1][it.code - aCode] = arr[idx][it.code - aCode]
        }
    }

    repeat(num) {
        val (c, l, r) = readln().split(" ")
        if (!exist.contains(c[0])) string.append(0).append("\n")
        else string.append(arr[r.toInt() + 1][c[0].code - aCode] - arr[l.toInt()][c[0].code - aCode]).append("\n")
    }

    println(string.toString())
}