class Or(vararg disjuncts: Sentence) : Sentence {

    val disjuncts = mutableListOf<Sentence>()

    init {
        this.disjuncts.addAll(disjuncts)
    }

    /**
     * Evaluates the logical sentence.
     */
    override fun evaluate(model: Map<String, Boolean>): Boolean =
        disjuncts.any { cnjct -> cnjct.evaluate(model) }

    /**
     * @return string formula representing logical sentence.
     */
    override fun formula(): String =
        if (disjuncts.size == 1) disjuncts[0].formula()
        else disjuncts.joinToString(" v ") { cnjct -> Sentence.parenthesize(cnjct.formula()) }


    /**
     *  Returns a set of all symbols in the logical sentence.
     */
    override fun symbols(): Set<String> =
        disjuncts.map { conjunct -> conjunct.symbols() }.flatten().toSet()


    override fun equals(other: Any?): Boolean =
        other is Or && this.disjuncts == other.disjuncts

    override fun toString(): String {
        val disjunctions = disjuncts.joinToString(", ") { it.toString() }
        return "${this::class.simpleName}($disjunctions)"
    }

    override fun hashCode(): Int {
        return disjuncts.hashCode()
    }

}