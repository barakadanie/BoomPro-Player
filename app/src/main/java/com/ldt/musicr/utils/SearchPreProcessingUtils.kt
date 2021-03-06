package com.ldt.musicr.utils

object SearchPreProcessingUtils {
    private val normalizes: Map<Char, Char> by lazy {
        val map = hashMapOf<Char, Char>()

        map['('] = ' '
        map[':'] = ' '
        map[';'] = ' '
        map['/'] = ' '
        map['-'] = ' '
        map[')'] = ' '
        map['?'] = ' '
        map[','] = ' '
        map['.'] = ' '
        map['@'] = ' '
        map['#'] = ' '
        map['%'] = ' '
        map['^'] = ' '
        map['&'] = ' '
        map['*'] = ' '
        map['!'] = ' '
        map['~'] = ' '
        map['+'] = ' '
        map['_'] = ' '
        map['='] = ' '
        map['\\'] = ' '
        map['['] = ' '
        map[']'] = ' '
        map['{'] = ' '
        map['}'] = ' '
        map['<'] = ' '
        map['>'] = ' '
        map['|'] = ' '
        map['`'] = ' '
        map['$'] = ' '
        map['\''] = ' '
        map['\"'] = ' '

        map['\u00E1'] = 'a'
        map['\u00E0'] = 'a'
        map['\u1EA3'] = 'a'
        map['\u00E3'] = 'a'
        map['\u1EA1'] = 'a'
        map['\u0103'] = 'a'
        map['\u1EAF'] = 'a'
        map['\u1EB1'] = 'a'
        map['\u1EB3'] = 'a'
        map['\u1EB5'] = 'a'
        map['\u1EB7'] = 'a'
        map['\u00E2'] = 'a'
        map['\u1EA5'] = 'a'
        map['\u1EA7'] = 'a'
        map['\u1EA9'] = 'a'
        map['\u1EAB'] = 'a'
        map['\u1EAD'] = 'a'
        map['\u0203'] = 'a'
        map['\u01CE'] = 'a'

        map['\u00E9'] = 'e'
        map['\u00E8'] = 'e'
        map['\u1EBB'] = 'e'
        map['\u1EBD'] = 'e'
        map['\u1EB9'] = 'e'
        map['\u00EA'] = 'e'
        map['\u1EBF'] = 'e'
        map['\u1EC1'] = 'e'
        map['\u1EC3'] = 'e'
        map['\u1EC5'] = 'e'
        map['\u1EC7'] = 'e'
        map['\u0207'] = 'e'

        map['\u00ED'] = 'i'
        map['\u00EC'] = 'i'
        map['\u1EC9'] = 'i'
        map['\u0129'] = 'i'
        map['\u1ECB'] = 'i'

        map['\u00F3'] = 'o'
        map['\u00F2'] = 'o'
        map['\u1ECF'] = 'o'
        map['\u00F5'] = 'o'
        map['\u1ECD'] = 'o'
        map['\u00F4'] = 'o'
        map['\u1ED1'] = 'o'
        map['\u1ED3'] = 'o'
        map['\u1ED5'] = 'o'
        map['\u1ED7'] = 'o'
        map['\u1ED9'] = 'o'
        map['\u01A1'] = 'o'
        map['\u1EDB'] = 'o'
        map['\u1EDD'] = 'o'
        map['\u1EDF'] = 'o'
        map['\u1EE1'] = 'o'
        map['\u1EE3'] = 'o'
        map['\u020F'] = 'o'

        map['\u00FA'] = 'u'
        map['\u00F9'] = 'u'
        map['\u1EE7'] = 'u'
        map['\u0169'] = 'u'
        map['\u1EE5'] = 'u'
        map['\u01B0'] = 'u'
        map['\u1EE9'] = 'u'
        map['\u1EEB'] = 'u'
        map['\u1EED'] = 'u'
        map['\u1EEF'] = 'u'
        map['\u1EF1'] = 'u'

        map['\u00FD'] = 'y'
        map['\u1EF3'] = 'y'
        map['\u1EF7'] = 'y'
        map['\u1EF9'] = 'y'
        map['\u1EF5'] = 'y'

        map['\u00C1'] = 'A'
        map['\u00C0'] = 'A'
        map['\u1EA2'] = 'A'
        map['\u00C3'] = 'A'
        map['\u1EA0'] = 'A'
        map['\u0102'] = 'A'
        map['\u1EAE'] = 'A'
        map['\u1EB0'] = 'A'
        map['\u1EB2'] = 'A'
        map['\u1EB4'] = 'A'
        map['\u1EB6'] = 'A'
        map['\u00C2'] = 'A'
        map['\u1EA4'] = 'A'
        map['\u1EA6'] = 'A'
        map['\u1EA8'] = 'A'
        map['\u1EAA'] = 'A'
        map['\u1EAC'] = 'A'
        map['\u0202'] = 'A'
        map['\u01CD'] = 'A'

        map['\u00C9'] = 'E'
        map['\u00C8'] = 'E'
        map['\u1EBA'] = 'E'
        map['\u1EBC'] = 'E'
        map['\u1EB8'] = 'E'
        map['\u00CA'] = 'E'
        map['\u1EBE'] = 'E'
        map['\u1EC0'] = 'E'
        map['\u1EC2'] = 'E'
        map['\u1EC4'] = 'E'
        map['\u1EC6'] = 'E'
        map['\u0206'] = 'E'

        map['\u00CD'] = 'I'
        map['\u00CC'] = 'I'
        map['\u1EC8'] = 'I'
        map['\u0128'] = 'I'
        map['\u1ECA'] = 'I'

        map['\u00D3'] = 'O'
        map['\u00D2'] = 'O'
        map['\u1ECE'] = 'O'
        map['\u00D5'] = 'O'
        map['\u1ECC'] = 'O'
        map['\u00D4'] = 'O'
        map['\u1ED0'] = 'O'
        map['\u1ED2'] = 'O'
        map['\u1ED4'] = 'O'
        map['\u1ED6'] = 'O'
        map['\u1ED8'] = 'O'
        map['\u01A0'] = 'O'
        map['\u1EDA'] = 'O'
        map['\u1EDC'] = 'O'
        map['\u1EDE'] = 'O'
        map['\u1EE0'] = 'O'
        map['\u1EE2'] = 'O'
        map['\u020E'] = 'O'

        map['\u00DA'] = 'U'
        map['\u00D9'] = 'U'
        map['\u1EE6'] = 'U'
        map['\u0168'] = 'U'
        map['\u1EE4'] = 'U'
        map['\u01AF'] = 'U'
        map['\u1EE8'] = 'U'
        map['\u1EEA'] = 'U'
        map['\u1EEC'] = 'U'
        map['\u1EEE'] = 'U'
        map['\u1EF0'] = 'U'

        map['\u00DD'] = 'Y'
        map['\u1EF2'] = 'Y'
        map['\u1EF6'] = 'Y'
        map['\u1EF8'] = 'Y'
        map['\u1EF4'] = 'Y'

        map['\u0110'] = 'D'
        map['\u00D0'] = 'D'
        map['\u0089'] = 'D'

        map['\u0111'] = 'd'

        map
    }

    private val asciiSpecialCharacters: Set<Char> by lazy {
        hashSetOf(
                '(',
                ':',
                ';',
                '/',
                '-',
                ')',
                '?',
                ',',
                '.',
                '@',
                '#',
                '%',
                '^',
                '&',
                '*',
                '!',
                '~',
                '+',
                '_',
                '=',
                '\\',
                '[',
                ']',
                '{',
                '}',
                '<',
                '>',
                '|',
                '`',
                '$',
                '\'',
                '\"')
    }

    private val viCompConsonants: Set<String> by lazy {
        hashSetOf(
                "ch", "Ch", "cH", "CH",
                "gh", "Gh", "gH", "GH",
                "kh", "Kh", "kH", "KH",
                "ng", "Ng", "nG", "NG",
                "nh", "Nh", "nH", "NH",
                "ph", "Ph", "pH", "PH",
                "th", "Th", "tH", "TH",
                "tr", "Tr", "tR", "TR")
    }

    private val viVowels: Set<Char> by lazy {
        hashSetOf(' ', 'u', 'e', 'o', 'a', 'i', 'y', 'U', 'E', 'O', 'A', 'I', 'Y')
    }

    private val viAccentedVowels by lazy {
        hashSetOf(
                // ?? ?? ?? ?? ?? ?? ?? ??? ?? ??? ?? ??? ??? ?? ??? ??? ?? ??? ?? ??? ?? ??? ?? ??? ??? ?? ??? ??? ?? ?? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ?? ??? ??? ??? ?? ??? ??? ?? ??? ??? ?? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??
                '\u01B0', // ??

                '\u01A1', // ??

                '\u00EA', // ??

                '\u00F4', // ??

                '\u00E2', // ??

                '\u0103', // ??

                '\u00F9', // ??

                '\u1EEB', // ???

                '\u00E8', // ??

                '\u1EC1', // ???

                '\u00F2', // ??

                '\u1EDD', // ???

                '\u1ED3', // ???

                '\u00E0', // ??

                '\u1EA7', // ???

                '\u1EB1', // ???

                '\u00EC', // ??

                '\u1EF3', // ???

                '\u00FA', // ??

                '\u1EE9', // ???

                '\u00E9', // ??

                '\u1EBF', // ???

                '\u00F3', // ??

                '\u1EDB', // ???

                '\u1ED1', // ???

                '\u00E1', // ??

                '\u1EA5', // ???

                '\u1EAF', // ???

                '\u00ED', // ??

                '\u00FD', // ??

                '\u1EE7', // ???

                '\u1EED', // ???

                '\u1EBB', // ???

                '\u1EC3', // ???

                '\u1ECF', // ???

                '\u1EDF', // ???

                '\u1ED5', // ???

                '\u1EA3', // ???

                '\u1EA9', // ???

                '\u1EB3', // ???

                '\u1EC9', // ???

                '\u1EF7', // ???

                '\u0169', // ??

                '\u1EEF', // ???

                '\u1EBD', // ???

                '\u1EC5', // ???

                '\u00F5', // ??

                '\u1EE1', // ???

                '\u1ED7', // ???

                '\u00E3', // ??

                '\u1EAB', // ???

                '\u1EB5', // ???

                '\u0129', // ??

                '\u1EF9', // ???

                '\u1EE5', // ???

                '\u1EF1', // ???

                '\u1EB9', // ???

                '\u1EC7', // ???

                '\u1ECD', // ???

                '\u1EE3', // ???

                '\u1ED9', // ???

                '\u1EA1', // ???

                '\u1EAD', // ???

                '\u1EB7', // ???

                '\u1ECB', // ???

                '\u1EF5', // ???

                // ?? ?? ?? ?? ?? ?? ?? ??? ?? ??? ?? ??? ??? ?? ??? ??? ?? ??? ?? ??? ?? ??? ?? ??? ??? ?? ??? ??? ?? ?? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ?? ??? ??? ??? ?? ??? ??? ?? ??? ??? ?? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??? ??
                '\u01AF', // ??

                '\u01A0', // ??

                '\u00CA', // ??

                '\u00D4', // ??

                '\u00C2', // ??

                '\u0102', // ??

                '\u00D9', // ??

                '\u1EEA', // ???

                '\u00C8', // ??

                '\u1EC0', // ???

                '\u00D2', // ??

                '\u1EDC', // ???

                '\u1ED2', // ???

                '\u00C0', // ??

                '\u1EA6', // ???

                '\u1EB0', // ???

                '\u00CC', // ??

                '\u1EF2', // ???

                '\u00DA', // ??

                '\u1EE8', // ???

                '\u00C9', // ??

                '\u1EBE', // ???

                '\u00D3', // ??

                '\u1EDA', // ???

                '\u1ED0', // ???

                '\u00C1', // ??

                '\u1EA4', // ???

                '\u1EAE', // ???

                '\u00CD', // ??

                '\u00DD', // ??

                '\u1EE6', // ???

                '\u1EEC', // ???

                '\u1EBA', // ???

                '\u1EC2', // ???

                '\u1ECE', // ???

                '\u1EDE', // ???

                '\u1ED4', // ???

                '\u1EA2', // ???

                '\u1EA8', // ???

                '\u1EB2', // ???

                '\u1EC8', // ???

                '\u1EF6', // ???

                '\u0168', // ??

                '\u1EEE', // ???

                '\u1EBC', // ???

                '\u1EC4', // ???

                '\u00D5', // ??

                '\u1EE0', // ???

                '\u1ED6', // ???

                '\u00C3', // ??

                '\u1EAA', // ???

                '\u1EB4', // ???

                '\u0128', // ??

                '\u1EF8', // ???

                '\u1EE4', // ???

                '\u1EF0', // ???

                '\u1EB8', // ???

                '\u1EC6', // ???

                '\u1ECC', // ???

                '\u1EE2', // ???

                '\u1ED8', // ???

                '\u1EA0', // ???

                '\u1EAC', // ???

                '\u1EB6', // ???

                '\u1ECA', // ???

                '\u1EF4', // ???

        )
    }

    private val viLetters: Set<Char> by lazy {
        // cod41fun -> should be code_49_fun
        // d4 -> splitable : d_4
        // 1f -> splitable: 1_f
        // 41 -> will not split

        val set = hashSetOf(
                'A',
                'B',
                'C',
                'D',
                'E',
                'F',
                'G',
                'H',
                'I',
                'J',
                'K',
                'L',
                'M',
                'N',
                'O',
                'P',
                'Q',
                'R',
                'S',
                'T',
                'U',
                'V',
                'W',
                'X',
                'Y',
                'Z',

                'a',
                'b',
                'c',
                'd',
                'e',
                'f',
                'g',
                'h',
                'i',
                'j',
                'k',
                'l',
                'm',
                'n',
                'o',
                'p',
                'q',
                'r',
                's',
                't',
                'u',
                'v',
                'w',
                'x',
                'y',
                'z')

        set.add('\u0111') // ??
        set.add('\u0110') // ??
        set.addAll(viAccentedVowels)

        set
    }

    /**
     * Note: output.size >= input.size
     * Return: the output length
     */
    @JvmStatic
    fun replaceSpecialCharWithSpace(input: CharArray, inputLength: Int, output: CharArray): Int {
        var outputLength = 0
        var increment: Int
        for (i in 0 until inputLength) {
            increment = 1
            if (asciiSpecialCharacters.contains(input[i])) {
                output[outputLength] = ' '
            } else when (input[i]) {
                '\u0300', '\u0301', '\u0303', '\u0309', '\u0323', '\u02C6', '\u03C6', '\u031B' -> {
                    increment = 0
                }
                else -> {
                    output[outputLength] = input[i]
                }
            }
            outputLength += increment
        }

        return outputLength
    }

    /**
     * Note: output.size >= input.size * 2
     * Return: the output length
     */
    @JvmStatic
    fun replaceSpecialCharAndAccentWithSpace(input: CharArray, inputLength: Int, output: CharArray): Int {
        var outputLength = 0
        var increment: Int
        for (i in 0 until inputLength) {
            increment = 1
            normalizes[input[i]]?.run {
                output[outputLength] = this
            } ?: when (input[i]) {
                '\u0300', '\u0301', '\u0303', '\u0309', '\u0323', '\u02C6', '\u03C6', '\u031B' -> {
                    increment = 0
                }
                else -> {
                    output[outputLength] = input[i]
                }
            }
            outputLength += increment
        }

        return outputLength
    }

    @JvmStatic
    private fun toLowercase(input: CharArray, inputLength: Int) {
        for (i in 0 until inputLength) {
            input[i] = input[i].lowercaseChar()
        }
    }

    @JvmStatic
    private fun splitBySpace(input: CharArray, inputLength: Int) : List<String> {
        return StringBuilder().append(input, 0, inputLength).split(' ')
    }

    private fun splitKeepOffsetBySpace(input: CharArray, inputLength: Int): Pair<ArrayList<String>, ArrayList<Int>> {
        return StringBuilder().append(input, 0, inputLength).splitKeepOffset(" ")
    }

    private fun CharSequence.splitKeepOffset(delimiter: String): Pair<ArrayList<String>, ArrayList<Int>> {
        return splitKeepOffset(delimiter, false, 0)
    }

    private fun CharSequence.splitKeepOffset(delimiter: String, ignoreCase: Boolean, limit: Int): Pair<ArrayList<String>, ArrayList<Int>> {
        require(limit >= 0) { "Limit must be non-negative, but was $limit." }

        var currentOffset = 0
        var nextIndex = indexOf(delimiter, currentOffset, ignoreCase)
        if (nextIndex == -1 || limit == 1) {
            return arrayListOf(this.toString()) to arrayListOf(0)
        }

        val isLimited = limit > 0
        val result = ArrayList<String>(if (isLimited) limit.coerceAtMost(10) else 10)
        val splitOffsets = ArrayList<Int>(if (isLimited) limit.coerceAtMost(10) else 10)
        do {
            result.add(substring(currentOffset, nextIndex))
            splitOffsets.add(currentOffset)
            currentOffset = nextIndex + delimiter.length
            // Do not search for next occurrence if we're reaching limit
            if (isLimited && result.size == limit - 1) break
            nextIndex = indexOf(delimiter, currentOffset, ignoreCase)
        } while (nextIndex != -1)

        result.add(substring(currentOffset, length))
        splitOffsets.add(currentOffset)
        return result to splitOffsets
    }

    private fun syncOffsetsWithAppendOffsets(arrayWordOffsets: ArrayList<Int>, appendOffsets: IntArray) {
        for (i in arrayWordOffsets.indices) {
            arrayWordOffsets[i] -= appendOffsets[arrayWordOffsets[i]]
        }
    }

    private fun Int.hasFlags(flagsNeedToCheck: Int): Boolean {
        return (this and flagsNeedToCheck) != 0
    }

    @JvmStatic
    fun appendSpacesRuleSplitWordEnhanced(keepAccents: Boolean, input: CharArray, inputLength: Int, output: CharArray, offsetLog: IntArray?): Int {
        // SPLIT RULE (here we 'split' 2 characters by appending a space between them):
        // Any 2-character string from input string, will be split into two, only when:
        // 1. both are not u, e, o, a, i, y or space
        // 2. both are not ??, ??, ??, ??, ...
        // 2. they do not make up "nh", "ng", "th" etc
        // 3. at least 1 character is not a digit ````\
        // 4. at least 1 character is a vietnamese letter  `------> condition 4 includes condition 3

        var outputLength = 0

        var charAtIndex: Char
        var charAfterIndex: Char
        for (i in 0 until inputLength - 1) {
            charAtIndex = input[i]
            charAfterIndex = input[i + 1]

            if (viVowels.contains(charAtIndex) || viVowels.contains(charAfterIndex)) {
                // ueoaiy and space
                output[outputLength] = charAtIndex
                outputLength++

                // log for append offsets
                offsetLog?.set(outputLength, outputLength - 1 -i)

                continue
            }
            if (keepAccents && (viAccentedVowels.contains(charAtIndex) || viAccentedVowels.contains(charAfterIndex))) {
                // ueoaiy accents
                output[outputLength] = charAtIndex
                outputLength++

                // log for append offsets
                offsetLog?.set(outputLength, outputLength - 1 -i)

                continue
            }

            if (viCompConsonants.contains(String(input, i, 2))) {
                // // "nh", "th", "ng" ...
                output[outputLength] = charAtIndex
                outputLength++

                // log for append offsets
                offsetLog?.set(outputLength, outputLength - 1 -i)

                continue
            }

            if (!viLetters.contains(charAtIndex) && !viLetters.contains(charAfterIndex)) {
                // "45", "??????", "???4" ...
                output[outputLength] = charAtIndex
                outputLength++

                // log for append offsets
                offsetLog?.set(outputLength, outputLength - 1 -i)

                continue
            }

            // here we add a space between two characters
            // andrew
            // >> "nd" -> "n d"
            // >> an, d, rew
            output[outputLength] = charAtIndex
            output[outputLength + 1] = ' '

            // increase output length by 2
            outputLength += 2

            // log for append offsets
            offsetLog?.set(outputLength - 1, outputLength - 1 - i)
            offsetLog?.set(outputLength, outputLength - 1 - i)

        }

        output[outputLength] = input[inputLength - 1]
        offsetLog?.set(outputLength, outputLength - (inputLength - 1))

        // outputIndex -> outputLength
        outputLength++

        return outputLength
    }

    @JvmStatic
    fun preprocessTypeNormal(input: String, @SearchConstant.PreprocessFlag flags: Int): PreProcessingOutput {
        val keepAccents = flags.hasFlags(SearchConstant.SEARCH_FLAG_PREPROCESS_KEEP_ACCENTS)
        val inputChars = input.toCharArray()

        val result = CharArray(inputChars.size)
        val resultLength = if (keepAccents) {
            replaceSpecialCharWithSpace(inputChars, inputChars.size, result)
        } else {
            replaceSpecialCharAndAccentWithSpace(inputChars, inputChars.size, result)
        }

        if(flags.hasFlags(SearchConstant.SEARCH_FLAG_TO_LOW_CASE)) {
            toLowercase(result, resultLength)
        }

        val arrayWords: Array<String>
        val arrayWordOffsets: IntArray?
        when {
            !flags.hasFlags(SearchConstant.SEARCH_FLAG_PREPROCESS_NO_ARRAY_WORD_OFFSETS) && flags.hasFlags(SearchConstant.SEARCH_FLAG_PREPROCESS_SPLIT_WORD_ENHANCED) && resultLength > 0 -> {
                /* Split word enhanced */
                val appendOffsets = IntArray(resultLength * 2)
                val enhancedResult = CharArray(resultLength * 2)
                val enhancedResultLength = appendSpacesRuleSplitWordEnhanced(keepAccents, result, resultLength, enhancedResult, appendOffsets)

                val enhancedResultOutput = splitKeepOffsetBySpace(enhancedResult, enhancedResultLength)
                syncOffsetsWithAppendOffsets(enhancedResultOutput.second, appendOffsets)

                arrayWords = enhancedResultOutput.first.toTypedArray()
                arrayWordOffsets = enhancedResultOutput.second.toIntArray()
            }

            !flags.hasFlags(SearchConstant.SEARCH_FLAG_PREPROCESS_NO_ARRAY_WORD_OFFSETS) && flags.hasFlags(SearchConstant.SEARCH_FLAG_PREPROCESS_SPLIT_WORD_EXTEND) && resultLength > 0 -> {
                /* Split word extend */
                val appendOffsets = IntArray(resultLength * 2)
                val enhancedResult = CharArray(resultLength * 2)
                val enhancedResultLength = appendSpacesRuleSplitWordEnhanced(keepAccents, result, resultLength, enhancedResult, appendOffsets)

                val legacyResultOutput = splitKeepOffsetBySpace(result, resultLength)
                val enhancedResultOutput = splitKeepOffsetBySpace(enhancedResult, enhancedResultLength)
                syncOffsetsWithAppendOffsets(enhancedResultOutput.second, appendOffsets)

                // -> Combine legacy and enhanced output into one: TADA!! "EXTEND"
                val extendResultOutput = arrayListOf<String>().apply { addAll(legacyResultOutput.first) }
                val extendResultOffsets = arrayListOf<Int>().apply { addAll(legacyResultOutput.second) }

                enhancedResultOutput.first.forEachIndexed { index, s ->
                    if(!legacyResultOutput.first.contains(s)) {
                        extendResultOutput.add(s)
                        extendResultOffsets.add(enhancedResultOutput.second[index])
                    }
                }
                arrayWords = extendResultOutput.toTypedArray()
                arrayWordOffsets = extendResultOffsets.toIntArray()
            }

            !flags.hasFlags(SearchConstant.SEARCH_FLAG_PREPROCESS_NO_ARRAY_WORD_OFFSETS) -> {
                /* Split word legacy */
                val legacyResultOutput = splitKeepOffsetBySpace(result, resultLength)
                arrayWords = legacyResultOutput.first.toTypedArray()
                arrayWordOffsets = legacyResultOutput.second.toIntArray()
            }

            flags.hasFlags(SearchConstant.SEARCH_FLAG_PREPROCESS_SPLIT_WORD_ENHANCED) && resultLength > 0 -> {
                /* Split word enhanced */
                val enhancedResult = CharArray(resultLength * 2)
                val enhancedResultLength = appendSpacesRuleSplitWordEnhanced(keepAccents, result, resultLength, enhancedResult, null)

                val enhancedResultOutput = splitBySpace(enhancedResult, enhancedResultLength)
                arrayWords = enhancedResultOutput.toTypedArray()
                arrayWordOffsets = null
            }

            flags.hasFlags(SearchConstant.SEARCH_FLAG_PREPROCESS_SPLIT_WORD_EXTEND) && resultLength > 0 -> {
                /* Split word extend */
                val enhancedResult = CharArray(resultLength * 2)
                val enhancedResultLength = appendSpacesRuleSplitWordEnhanced(keepAccents, result, resultLength, enhancedResult, null)

                val legacyResultOutput = splitBySpace(result, resultLength)
                val enhancedResultOutput = splitBySpace(enhancedResult, enhancedResultLength)

                // -> Combine legacy and enhanced output into one: TADA!! "EXTEND"
                val extendResultOutput = arrayListOf<String>().apply { addAll(legacyResultOutput) }

                enhancedResultOutput.forEachIndexed { _, s ->
                    if(!legacyResultOutput.contains(s)) {
                        extendResultOutput.add(s)
                    }
                }
                arrayWords = extendResultOutput.toTypedArray()
                arrayWordOffsets = null
            }

            else -> {
                /* Split word legacy */
                val legacyResultOutput = splitBySpace(result, resultLength)
                arrayWords = legacyResultOutput.toTypedArray()
                arrayWordOffsets = null
            }

        }

        return arrayWordOffsets?.let { PreProcessingOffsetOutput(arrayWords, it) } ?: PreProcessingOutput(arrayWords)
    }

    @JvmStatic
    fun preprocessTypeSearch(input: String, @SearchConstant.PreprocessFlag flags: Int): PreProcessingOutput {
        return preprocessTypeNormal(input, flags)
    }

    @JvmStatic
    fun preprocessTypeKey(input: String, @SearchConstant.PreprocessFlag flags: Int): PreProcessingOutput {
        return preprocessTypeNormal(input, flags)
    }

    @JvmStatic
    fun preprocessTypeKeyUsername(input: String, @SearchConstant.PreprocessFlag flags: Int): PreProcessingOutput {
        val outputTypeKey = preprocessTypeKey(input, flags)

        return if (outputTypeKey is PreProcessingOffsetOutput) {
            val arrayWords = arrayListOf<String>()
            val arrayWordOffsets = arrayListOf<Int>()

            outputTypeKey.arrayWords.forEachIndexed { index, s ->
                if (s.isNotEmpty()) {
                    arrayWords.add(s)
                    arrayWordOffsets.add(outputTypeKey.arrayWordOffsets[index])
                }
            }
            PreProcessingOffsetOutput(arrayWords.toTypedArray(), arrayWordOffsets.toIntArray())
        } else {
            val arrayWords = arrayListOf<String>()

            outputTypeKey.arrayWords.forEachIndexed { _, s ->
                if (s.isNotEmpty()) {
                    arrayWords.add(s)
                }
            }
            PreProcessingOutput(arrayWords.toTypedArray())
        }
    }
}