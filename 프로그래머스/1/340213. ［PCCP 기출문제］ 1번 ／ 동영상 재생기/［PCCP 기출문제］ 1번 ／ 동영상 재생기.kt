class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        val (lm, ls) = video_len.split(":").map { it.toInt() }
        val lt = lm * 60 + ls
        val (m, s) = pos.split(":").map { it.toInt() }
        var t = m * 60 + s
        val (sm, ss) = op_start.split(":").map { it.toInt() }
        val st = sm * 60 + ss
        val (em, es) = op_end.split(":").map { it.toInt() }
        val et = em * 60 + es

        if (t in st..et) t = et

        for (c in commands) {
            when (c) {
                "next" -> {
                    t += 10
                    if (t > lt) t = lt
                    if (t in st..et) t = et
                }
                else -> {
                    t -= 10
                    if (t < 0) t = 0
                    if (t in st..et) t = et
                }
            }
        }

        return "${String.format("%02d", t / 60)}:${String.format("%02d", t % 60)}"
    }
}