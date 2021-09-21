fun modelCheck(knowledge: Sentence, query: Sentence): Boolean {

    fun checkAll(
        knowledge: Sentence,
        query: Sentence,
        symbols: Set<String>,
        model: HashMap<String, Boolean>
    ): Boolean {

        if (symbols.isEmpty()) {
            return if (knowledge.evaluate(model))
                query.evaluate(model)
            else
                true
        } else {
            // Take one of the remaining symbols
            val remaining = mutableSetOf<String>()
            remaining.addAll(symbols)
            val symbol = symbols.first()
            remaining.remove(symbol)

            // Create a model where symbol is true
            val modelTrue = HashMap<String, Boolean>(model)
            modelTrue[symbol] = true


            // Create a model where symbol is false
            val modelFalse = HashMap<String, Boolean>(model)
            modelFalse[symbol] = false

            // Ensure entailment holds in both models
            return (checkAll(knowledge, query, remaining, modelTrue) &&
                    checkAll(knowledge, query, remaining, modelFalse))
        }
    }

    // Get all symbols from both knowledge and query
    val symbols = knowledge.symbols().union(query.symbols())

    // Check that knowledge entails query
    return checkAll(knowledge, query, symbols, model = HashMap())

}


fun checkKnowledge(knowledge: Sentence, symbols: Iterable<Symbol>) {
    for (symbol in symbols) {
        // If it can infer that the query is true
        if (modelCheck(knowledge, symbol)) println("$symbol: YES")
        // If it can't infer that it is not true (It is unsure)
        else if (!modelCheck(knowledge, Not(symbol))) println("$symbol: MAYBE")
        // Do nothing if it's sure the symbol is false
    }
}