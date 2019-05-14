package googleProblems

class decompressor {

    private val regex = "\\d+[[a-z]+]"

    private fun matchTrans(match: MatchResult): CharSequence {
        val m = match.value
        val resultCnt = Regex.fromLiteral("\\d+").matchEntire(m)
        val cnt = resultCnt?.value?.toInt() ?: -1
        val resultChars = Regex.fromLiteral("[a-z]+").matchEntire(m)
        val chars = resultChars?.value ?: ""
        return if (cnt == -1)
            m
        else
            chars.repeat(cnt)
    }

    private fun substitution(pattern: String, input: String, matchTransform: (MatchResult) -> CharSequence): String {
        return Regex.fromLiteral(pattern).replace(input, matchTransform)
    }

    fun decompressSubstitute(input: String): String {
        return substitution(regex, input, ::matchTrans)
    }

    fun decompress(input: String): String {
        val out = decompressSubstitute(input)
        return if (input == out)
            out
        else
            decompress(out)
    }
}

fun main(args: Array<String>) {
    val decomp = decompressor()

    println(decomp.decompress("2[3[a]b]"))
}