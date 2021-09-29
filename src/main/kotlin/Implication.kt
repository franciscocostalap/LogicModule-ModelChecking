data class Implication(val antecedent: Sentence, val consequent: Sentence) : Sentence {

    /**
     * Evaluates the logical sentence.
     *
     *  Implication -> ~Antecedent v Consequent
     *
     */
    override fun evaluate(model: Map<String, Boolean>): Boolean =
        !(antecedent.evaluate(model)) || consequent.evaluate(model)


    /**
     * @return string formula representing logical sentence.
     */
    override fun formula(): String {
        val ante = Sentence.parenthesize(antecedent.formula())
        val conse = Sentence.parenthesize(consequent.formula())
        return "$ante => $conse"
    }

    /**
     *  Returns a set of all symbols names in the logical sentence.
     */
    override fun symbols(): Set<String> =
        antecedent.symbols().union(consequent.symbols())


    override fun toString(): String =
        "${this::class.simpleName}($antecedent, $consequent)"


}