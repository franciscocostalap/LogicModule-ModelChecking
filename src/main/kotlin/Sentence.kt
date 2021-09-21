interface Sentence {

    /**
     * Evaluates the logical sentence.
     */
    fun evaluate(model: Map<String, Boolean>): Boolean

    /**
     * @return string formula representing logical sentence.
     */
    fun formula(): String

    /**
     *  Returns a set of all symbols names in the logical sentence.
     */
    fun symbols(): Set<String>

    companion object {
        fun parenthesize(s: String): String {
            /**
             * Checks if a string has balanced parentheses.
             *
             * @param s string in question
             *
             * @return true, if the string has balanced parentesis, else false
             */
            fun isBalanced(s: String): Boolean {
                var count = 0
                for (char in s)
                    if (char == '(') count++
                    else if (char == ')') {
                        if (count <= 0) return false
                        count--
                    }
                return count == 0
            }

            if (s.isEmpty() || s.all { it.isLetter() } || (s.first() == '(' && s.last() == ')' && isBalanced(
                    s.substring(
                        1,
                        s.lastIndex
                    )
                )))
                return s
            else
                return "($s)"
        }
    }
}