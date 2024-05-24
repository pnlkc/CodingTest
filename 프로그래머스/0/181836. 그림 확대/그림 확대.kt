class Solution {
    fun solution(picture: Array<String>, k: Int): Array<String> {
        val list = mutableListOf<String>()

        picture.forEach { str ->
            val sb = StringBuilder()

            str.forEach { c -> repeat(k) { sb.append(c) } }
            repeat(k) { list.add(sb.toString()) }
        }

        return list.toTypedArray()
    }
}