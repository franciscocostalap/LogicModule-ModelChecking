class Not(val operand: Sentence) : Sentence {

    /**
     * Evaluates the logical sentence.
     */
    override fun evaluate(model: Map<String, Boolean>): Boolean =
        !this.operand.evaluate(model)


    /**
     * @return string formula representing logical sentence.
     */
    override fun formula(): String =
        "~" + Sentence.parenthesize(this.operand.formula())


    /**
     *  Returns a set of all symbols' names in the logical sentence.
     */
    override fun symbols(): Set<String> = this.operand.symbols()


    override fun equals(other: Any?): Boolean =
        other is Not && this.operand == other.operand


    override fun toString(): String =
        "${this::class.simpleName}(${this.operand})"


}