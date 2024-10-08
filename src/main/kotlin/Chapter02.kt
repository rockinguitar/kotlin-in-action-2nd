package rocks.aendu.kotlin

fun main() {
    val myName = "Samuel L. Jackson"
    println("Hello $myName")
    println("What is max: ${max(2,3)}")
    val languages = mutableListOf("Java")
    languages.add("Kotlin")
    println(languages)
    val firstPerson = Person(myName, false)
    println(firstPerson)
    println(firstPerson.name)
    println(firstPerson.isStudent)
    val square = Rectangle(200, 200)
    println("Is square: ${square.isSquare}")
    println(Color.BLUE.rgb)
    // 255
    Color.GREEN.printColor()
    println(getMnemonic(Color.BLUE))
    println(getWarmthFromSensor())
    println(mix(Color.BLUE, Color.VIOLET))
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
}

fun max(a: Int, b: Int) = if (a > b) a else b

class Person(val name: String, var isStudent: Boolean)

class Rectangle(height: Int, width: Int) {
    val isSquare: Boolean = height == width
}

enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);
    val rgb = (r * 256 + g) * 256 + b
    fun printColor() = println("$this is $rgb")
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun measureColor() = Color.ORANGE
// as a stand-in for more complex measurement logic

fun getWarmthFromSensor(): String = when(val color = measureColor()) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm (red = ${color.r})"
    Color.GREEN -> "neutral (green = ${color.g})"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (blue = ${color.b})"
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}
