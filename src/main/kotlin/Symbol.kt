data class Symbol(val name: String) : Sentence {

    /**
     * Evaluates the logical sentence.
     */
    override fun evaluate(model: Map<String, Boolean>): Boolean =
        model[name] ?: throw NoSuchElementException("No such symbol in model")

    /**
     * @return string formula representing logical sentence.
     */
    override fun formula(): String = toString()

    /**
     *  Returns a set of all symbols in the logical sentence.
     */
    override fun symbols(): Set<String> = setOf(this.name)

    override fun toString(): String = this.name

}
