import org.junit.Test
import kotlin.test.*


class SymbolTest : SentenceTest {

    @Test
    override fun constructorTest() {
        val symbol = Symbol("hello")
        assertEquals(symbol.name, "hello", "Name field equality")
    }

    @Test
    override fun equalsTest() {
        val sameName = "Harry visited hagrid"
        val symbolInQuestion = Symbol(sameName)
        val symbolWithSameName = Symbol(sameName)
        val symbolWithDifferentName = Symbol("Harry visited someone else")
        val notASymbolWithSymbol: Sentence = And(Symbol(sameName))
        val notASymbolEither: Sentence = And(Symbol("Hello world"))

        assertEquals(symbolInQuestion, symbolWithSameName, "Equal Symbols")
        assertNotEquals(symbolInQuestion, symbolWithDifferentName, "Symbols with different names")
        assertNotEquals(symbolInQuestion, notASymbolWithSymbol, "Symbol and Not Symbol")
        assertNotEquals(symbolInQuestion, notASymbolEither, "Symbol and Not Symbol")

    }

    @Test
    override fun symbolsTest() {
        val symbol = Symbol("I'm home")
        val symbols = symbol.symbols()
        val equalSet = setOf(symbol.name)

        assertTrue(symbols.contains(symbol.name), "Set containing it's object")
        assertTrue(symbols.size == 1, "Test set size")
        assertEquals(symbols, equalSet, "Test equality with an equal set")
    }

    @Test
    override fun evaluateTest() {
        val name = "Symbol's Name"
        val symbol = Symbol(name)
        val model = HashMap<String, Boolean>()

        assertFailsWith(NoSuchElementException::class, "Test Exception throw") { symbol.evaluate(model) }
        model[name] = true
        assertTrue(symbol.evaluate(model))
        model[name] = false
        assertFalse(symbol.evaluate(model))

    }

    @Test
    override fun formulaTest() {
        val name = "Symbol's Name"
        val symbol = Symbol(name)

        assertEquals(name, symbol.formula(), "Test Formula Equality")
    }

    @Test
    override fun toStringTest() {
        val name = "Symbol's Name"
        val symbol = Symbol(name)

        assertEquals(name, symbol.toString(), "Test toString Equality")
    }
}