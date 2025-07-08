import java.io.InputStream

fun main() {
    val reader = FastReader()
    val N = reader.nextInt()
    val isExist = BooleanArray(N + 1)

    repeat(N) {
        val num = reader.nextInt()

        if (isExist[num]) {
            println(num)
            return
        }

        isExist[num] = true
    }
}

class FastReader(private val input: InputStream = System.`in`) {
    private val buffer = ByteArray(1 shl 16)
    private var ptr = 0
    private var len = 0

    private fun readByte(): Byte {
        if (ptr >= len) {
            len = input.read(buffer)
            ptr = 0
            if (len == -1) return -1
        }
        return buffer[ptr++]
    }

    fun nextInt(): Int {
        var b = readByte()

        while (b <= ' '.code.toByte()) b = readByte()

        var neg = false

        if (b == '-'.code.toByte()) {
            neg = true
            b = readByte()
        }

        var n = 0

        while (b in '0'.code.toByte()..'9'.code.toByte()) {
            n = n * 10 + (b - '0'.code.toByte())
            b = readByte()
        }

        return if (neg) -n else n
    }
}