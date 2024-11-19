fun main() {
    val sb = StringBuilder()
    val (N, M) = readln().split(" ").map { it.toInt() }
    val teamMap = mutableMapOf<String, MutableList<String>>()
    val memberMap = mutableMapOf<String, String>()

    for (i in 1..N) {
        val team = readln()
        teamMap[team] = mutableListOf()

        for (j in 1..readln().toInt()) {
            val member = readln()
            teamMap[team]!!.add(member)
            memberMap[member] = team
        }

        teamMap[team]!!.sort()
    }

    for (i in 1..M) {
        val input = readln()
        val command = readln().toInt()

        if (command == 0) {
            sb.appendLine(teamMap[input]!!.joinToString("\n"))
        } else {
            sb.appendLine(memberMap[input]!!)
        }
    }

    print(sb)
}