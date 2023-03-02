fun main() {
    var answer = StringBuilder()
    val array = Array(5) { CharArray(15) { ' ' } }

    for (i in 0..4) {
        val input = readln().toCharArray()

        for (j in input.indices) {
            array[i][j] = input[j]
        }
    }
    
    for (i in 0..14) {
        for (j in 0..4){
            if (array[j][i] != ' ') answer.append(array[j][i]) 
        }
    }
    
    println(answer.toString())
}