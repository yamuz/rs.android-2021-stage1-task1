package subtask3

import com.sun.xml.internal.fastinfoset.util.StringArray

class StringParser {

    // TODO: Complete the following function
    fun getResult(istr: String): Array<String> {
        val result = mutableListOf<String>()
        recycleString(result, istr)

        return result.toTypedArray()

    }

    private fun recycleString(res: MutableList<String>, s:String){
        var open1 = 0
        var close1= 0
        var startIndex1 = 0

        var closeChar : Char? = null
        var openChar : Char? = null

        for (i in 0..s.length-1) {
            open1  = 0
            close1 = 0

            if (s[i] == '<' || s[i] == '(' || s[i] == '[') {
                openChar = s[i]
                when (s[i]){
                    '<' -> closeChar = '>'
                    '(' -> closeChar = ')'
                    '[' -> closeChar = ']'
                }
                if (open1 == 0)
                    startIndex1 = i
                open1++

                for (j in i+1..s.length - 1) {
                    if (s[j] == openChar) {
                        open1++
                    }
                    if (s[j] == closeChar) {
                        close1++
                        if (open1 == close1) {
                            res.add(s.subSequence(startIndex1 + 1, j) as String)
                            break
                        }
                    }
                }
            }

        }
    }



}



