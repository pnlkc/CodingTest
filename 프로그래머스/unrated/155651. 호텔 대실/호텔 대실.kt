class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var a = IntArray(1451) { 0 }
        book_time.forEach {
            val (h1, m1) = it[0].split(":").map { s -> s.toInt() }
            val (h2, m2) = it[1].split(":").map { s -> s.toInt() }

            for (i in (h1 * 60 + m1)..(h2 * 60 + m2 + 9)) {
                a[i]++
            }
        }

        return a.maxOrNull()!!
    }
}