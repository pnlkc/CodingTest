class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()

        var list = mutableListOf<String>()

        course.forEach { element ->
            var allList = listOf<String>()
            orders.filter { it.length >= element }.forEach {
                combination(it.toList().sorted(), element)
                    .map { it.joinToString("") }
                    .forEach { list.add(it) }
            }
        }

        list.groupBy { it.length }.forEach { mapElement ->
            val map = mutableMapOf<Int, MutableList<String>>()
            mapElement.value.forEach { element ->
                if (map[mapElement.value.count { it == element }] != null) {
                    map[mapElement.value.count { it == element }]!!.add(element)
                } else {
                    map[mapElement.value.count { it == element }] = mutableListOf()
                }
            }
            var countList = map.toSortedMap().toMap()
            if (countList.keys.last() != 1) answer += countList.values.last().distinct()
        }

        return answer.sorted().toTypedArray()
    }

    fun <T> combination(
        inputList: List<T>,
        num: Int,
        fin: List<T> = listOf(),
        index: Int = 0,
    ): List<List<T>> {
        return if (fin.size >= num) {
            listOf(fin)
        } else {
            inputList.slice(index until inputList.size)
                .flatMapIndexed { i: Int, t: T ->
                    combination(inputList, num, fin + t, index + i + 1)
                }
        }
    }
}