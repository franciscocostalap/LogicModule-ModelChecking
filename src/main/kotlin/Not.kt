class Not(val operand: Sentence) : Sentence {

    override fun evaluate(model: Map<String, Boolean>): Boolean {
        return !this.operand.evaluate(model)
    }

    /**
     * @return string formula representing logical sentence.
     */
    override fun formula(): String {
        return "~" + Sentence.parenthesize(this.operand.formula())
    }

    /**
     *  Returns a set of all symbols' names in the logical sentence.
     */
    override fun symbols(): Set<String> {
        return this.operand.symbols()
    }

    override fun equals(other: Any?): Boolean {
        return other is Not && this.operand == other.operand
    }

    override fun toString(): String {
        return "${this::class.simpleName}(${this.operand})"
    }

}