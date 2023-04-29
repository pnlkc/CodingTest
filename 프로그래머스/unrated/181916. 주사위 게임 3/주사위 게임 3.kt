class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        val map = mutableMapOf<Int, Int>()
        map[a] = 1 + (map[a] ?: 0)
        map[b] = 1 + (map[b] ?: 0)
        map[c] = 1 + (map[c] ?: 0)
        map[d] = 1 + (map[d] ?: 0)

        return when {
            map.values.maxOf { it } == 4 -> map.keys.first() * 1111
            map.values.maxOf { it } == 3 -> {
                val p = map.filter { it.value == 3 }.keys.first()
                val q = map.keys.first { it != p }
                (10 * p + q) * (10 * p + q)
            }
            map.values.maxOf { it } == 2 && map.values.minOf { it } == 2 -> {
                val subtract = map.keys.first() - map.keys.last()
                map.keys.sum() * if (subtract < 0) -subtract else subtract
            }
            map.values.maxOf { it } == 2 -> map.filter { it.value != 2 }.keys.let { it.first() * it.last() }
            else -> map.keys.minOrNull()!!
        }
    }
}