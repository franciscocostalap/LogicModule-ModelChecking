import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class NotTest : SentenceTest {

    @Test
    override fun constructorTest() {
        val symbol = Symbol("A symbol")
        val notSymbol = Not(symbol)

        assertEquals(symbol, notSymbol.operand)
    }

    @Test
    override fun equalsTest() {
        val sameName = "Harry visited hagrid"
        val symbolInQuestion = Not(Symbol(sameName))
        val symbolWithSameName = Not(Symbol(sameName))
        val symbolWithDifferentName = Not(Symbol("Harry visited someone else"))
        val notASymbolWithSymbol: Sentence = And(Not(Symbol(sameName)))
        val notASymbolEither: Sentence = And(Symbol("Hello world"))


        assertEquals(symbolInQuestion, symbolWithSameName, "Equal Symbols")
        assertNotEquals(symbolInQuestion, symbolWithDifferentName, "Symbols with different names")
        assertNotEquals(symbolInQuestion, notASymbolWithSymbol, "Symbol and Not Symbol")
        assertNotEquals(symbolInQuestion, notASymbolEither, "Symbol and Not Symbol")
    }

    @Test
    override fun symbolsTest() {
        TODO("Not yet implemented")
    }

    @Test
    override fun evaluateTest() {
        TODO("Not yet implemented")
    }

    @Test
    override fun formulaTest() {
        TODO("Not yet implemented")
    }

    @Test
    override fun toStringTest() {
        TODO("Not yet implemented")
    }

}