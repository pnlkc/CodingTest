class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val map = players.mapIndexed { idx, s -> s to idx }.toMap().toMutableMap()
        
        callings.forEach {
            val c = map[it]!!
            val prev = players[c - 1]
            players[c - 1] = it
            players[c] = prev
            map[it] = map[it]!! - 1
            map[prev] = map[prev]!! + 1
        }

        return players
    }
}