class And(vararg conjuncts: Sentence) : Sentence {

    val conjuncts: MutableList<Sentence> = mutableListOf()

    init {
        this.conjuncts.addAll(conjuncts)
    }

    fun add(conjunct: Sentence) {
        this.conjuncts.add(conjunct)
    }

    /**
     * Evaluates the logical sentence.
     */
    override fun evaluate(model: Map<String, Boolean>): Boolean =
        conjuncts.all { cnjct -> cnjct.evaluate(model) }

    /**
     * @return string formula representing logical sentence.
     */
    override fun formula(): String {
        if (conjuncts.size == 1) return conjuncts[0].formula()
        return conjuncts.joinToString(" ^ ") { cnjct -> Sentence.parenthesize(cnjct.formula()) }
    }

    /**
     *  Returns a set of all symbols in the logical sentence.
     */
    override fun symbols(): Set<String> =
        conjuncts.map { conjunct -> conjunct.symbols() }.flatten().toSet()


    override fun equals(other: Any?): Boolean =
        other is And && this.conjuncts == other.conjuncts

    override fun toString(): String {
        val conjunctions = conjuncts.joinToString(", ") { it.toString() }
        return "${this::class.simpleName}($conjunctions)"
    }

}