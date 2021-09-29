data class Biconditional(val left: Sentence, val right: Sentence) : Sentence {

    /**
     * Evaluates the logical sentence.
     */
    override fun evaluate(model: Map<String, Boolean>): Boolean {
        val bothTrue = left.evaluate(model) && right.evaluate(model)
        val bothFalse = !left.evaluate(model) && !right.evaluate(model)

        return bothTrue || bothFalse
    }

    /**
     * @return string formula representing logical sentence.
     */
    override fun formula(): String {
        val l = Sentence.parenthesize(left.formula())
        val r = Sentence.parenthesize(right.formula())
        return "$l <=> $r"
    }

    /**
     *  Returns a set of all symbols names in the logical sentence.
     */
    override fun symbols(): Set<String> =
        left.symbols().union(right.symbols())

    override fun toString(): String =
        "${this::class.simpleName}($left, $right)"

}