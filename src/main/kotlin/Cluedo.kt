fun main() {

    val symbols = mutableSetOf<Symbol>()

    //  Define Character Symbols
    val scarlet = Symbol("Scarlet")
    val mustard = Symbol("Mustard")
    val plum = Symbol("plum")

    symbols.add(scarlet)
    symbols.add(mustard)
    symbols.add(plum)

    // Define room Symbols
    val ballroom = Symbol("Ballroom")
    val kitchen = Symbol("Kitchen")
    val library = Symbol("Library")

    symbols.add(ballroom)
    symbols.add(kitchen)
    symbols.add(library)

    // Define weapon Symbols
    val knife = Symbol("Knife")
    val revolver = Symbol("Revolver")
    val wrench = Symbol("Wrench")

    symbols.add(knife)
    symbols.add(revolver)
    symbols.add(wrench)

    // Add game rules to the knowledge

    val knowledge = And(                    //  This piece of knowledge
        Or(mustard, plum, scarlet),         //  means that at least one
        Or(ballroom, kitchen, library),     //  of each types is part
        Or(knife, revolver, wrench)         //  of the solution
    )

    knowledge.add(Not(mustard)) // I have the mustard card so it means mustard is not the murderer
    knowledge.add(Not(kitchen)) // Same for the kitchen card
    knowledge.add(Not(revolver)) // Same for the revolver card

    /*

       Someone took a guess (Scarlet, Kitchen, Wrench) and got it wrong!
       That means at least one of them is wrong!

    */
    knowledge.add(
        Or(
            Not(scarlet), Not(library), Not(wrench)
        )
    )

    // Finally after some rounds I've seen the plum and ballroom cards
    // I know they aren't part of the solution

    knowledge.add(Not(plum))
    knowledge.add(Not(ballroom))

    checkKnowledge(knowledge, symbols)
}