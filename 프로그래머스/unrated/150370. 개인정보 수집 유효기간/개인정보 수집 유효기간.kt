class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        val todaySplit = today.split(".").map { it.toInt() }
        val mapTerms = mutableMapOf<String, Int>()
        terms.forEach { mapTerms[it.split(" ")[0]] = it.split(" ")[1].toInt() }

        for (i in privacies.indices) {
            val (date, type) = privacies[i].split(" ")
            val splitDate = date.split(".").map { it.toInt() }.toIntArray()
            splitDate[1] += mapTerms[type]!!
            splitDate[0] += (splitDate[1] - 1) / 12
            splitDate[1] = if (splitDate[1] % 12 == 0) 12 else splitDate[1] % 12

            when {
                todaySplit[0] < splitDate[0] -> continue
                todaySplit[0] > splitDate[0] -> answer.add(i + 1)
                else -> {
                    when {
                        todaySplit[1] < splitDate[1] -> continue
                        todaySplit[1] > splitDate[1] -> answer.add(i + 1)
                        else -> {
                            when {
                                todaySplit[2] >= splitDate[2] -> answer.add(i + 1)
                                else -> continue
                            }
                        }
                    }
                }
            }
        }

        return answer.toIntArray()
    }
}