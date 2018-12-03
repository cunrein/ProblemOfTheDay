package problemSeven

// Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
// count the number of ways it can be decoded.

fun countNumberDecodings(message: CharArray, len: Int): Int {
    if (len == 0 || len == 1) return 1
    var count = 0
    if (message[len - 1] > '0') {
        count = countNumberDecodings(message, len - 1)
    }
    if (message[len - 2] == '1' ||
        (message[len - 2] == '2' && message[len - 1] < '7')
    ) {
        count += countNumberDecodings(message, len - 2)
    }

    return count
}