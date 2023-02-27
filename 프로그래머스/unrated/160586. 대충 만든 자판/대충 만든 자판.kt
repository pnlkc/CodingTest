class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val answer = IntArray(targets.size) { 0 }
        val map = mutableMapOf<Char, Int>()
        ('A'..'Z').forEach {
            map[it] = 101
        }

        keymap.forEach { key ->
            key.forEachIndexed { i, char ->
                if (map[char]!! > i + 1 ) map[char] = i + 1
            }
        }

        targets.forEachIndexed { i, target ->
            answer[i] = 0
            for (char in target) {
                when (map[char]) {
                    101 -> {
                        answer[i] = -1
                        break
                    }
                    else -> answer[i] += map[char]!!
                }
            }
        }

        return answer
    }
}