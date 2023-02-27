class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var leftPos = listOf(4, 1)
        var rightPos = listOf(4, 3)

        val numpad = mapOf(
            1 to listOf(1, 1), 2 to listOf(1, 2), 3 to listOf(1, 3),
            4 to listOf(2, 1), 5 to listOf(2, 2), 6 to listOf(2, 3),
            7 to listOf(3, 1), 8 to listOf(3, 2), 9 to listOf(3, 3),
            0 to listOf(4, 2)
        )

        for (i in numbers.indices) {
            val addLeft = {
                answer += "L"
                leftPos = numpad[numbers[i]]!!
            }

            val addRight = {
                    answer += "R"
                    rightPos = numpad[numbers[i]]!!
            }

            when (numpad[numbers[i]]!!.last()) {
                1 -> addLeft()
                2 -> {
                    val leftDiff = getDiff(leftPos, numpad[numbers[i]]!!)
                    val rightDiff = getDiff(rightPos, numpad[numbers[i]]!!)
                    when {
                        leftDiff - rightDiff > 0 -> addRight()
                        leftDiff - rightDiff < 0 -> addLeft()
                        leftDiff - rightDiff == 0 -> if (hand == "left") addLeft() else addRight()
                    }
                }
                3 -> addRight()
            }
        }
        return answer
    }

    private fun getDiff(firstNum: List<Int>, secondNum: List<Int>) : Int {
        val getDiff = { num1: Int, num2: Int -> if (num1 > num2) num1 - num2 else num2 - num1 }
        val xDiff = getDiff(firstNum.first(), secondNum.first())
        val yDiff = getDiff(firstNum.last(), secondNum.last())
        return xDiff + yDiff
    }
}