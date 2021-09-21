class Or(vararg disjuncts: Sentence) : Sentence {
    val disjuncts = mutableListOf<Sentence>()

    init {
        this.disjuncts.addAll(disjuncts)
    }

    override fun evaluate(model: Map<String, Boolean>): Boolean =
        disjuncts.all { cnjct -> cnjct.evaluate(model) }

    /**
     * @return string formula representing logical sentence.
     */
    override fun formula(): String {
        if (disjuncts.size == 1) return disjuncts[0].formula()
        return disjuncts.joinToString(" ^ ") { cnjct -> Sentence.parenthesize(cnjct.formula()) }
    }

    /**
     *  Returns a set of all symbols in the logical sentence.
     */
    override fun symbols(): Set<String> =
        disjuncts.map { conjunct -> conjunct.symbols() }.flatten().toSet()


    override fun equals(other: Any?): Boolean =
        other is And && this.disjuncts == other.conjuncts

    override fun toString(): String {
        val conjunctions = disjuncts.joinToString(", ") { it.toString() }

        return "${this::class.simpleName}($conjunctions)"
    }

}