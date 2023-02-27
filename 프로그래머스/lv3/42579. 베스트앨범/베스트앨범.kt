class Data(val genre: String, val play: Int, val index: Int)
class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.mapIndexed { i, s -> Data(s, plays[i], i) }
            .groupBy { it.genre }
            .map {
                it.key to (it.value.map { data -> data.play to data.index }
                    .sortedByDescending { map -> map.first })
            }
            .sortedByDescending { it.second.sumOf { play -> play.first } }
            .fold(intArrayOf()) { acc: IntArray, pair ->
                acc + if (pair.second.size > 1) {
                    intArrayOf(pair.second[0].second, pair.second[1].second)
                } else {
                    intArrayOf(pair.second[0].second)
                }
            }
    }
}