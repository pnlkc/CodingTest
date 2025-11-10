fun main() {
    val str = readln()
    var temp = ""

    when {
        str.contains('_') -> {
            val list = str.split("_")

            for (i in list.indices) {

                if (list[i].isEmpty()) {
                    println("Error!")
                    return
                }

                for (j in list[i].indices) {
                    if (!list[i][j].isLowerCase()) {
                        println("Error!")
                        return
                    }
                }
            }

            for (i in list.indices) {
                temp += if (i == 0) list[i] else list[i][0].uppercase() + list[i].substring(1)
            }
        }
        else -> {
            if (str[0].isUpperCase()) {
                println("Error!")
                return
            }

            for (i in str.indices) {
                temp += if (str[i].isUpperCase()) "_${str[i].lowercase()}" else str[i]
            }
        }
    }

    println(temp)
}