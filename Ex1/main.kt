fun algorithm(a: Int, b: Int, c: Int) {
  if (a != 0 && b != 0 && c != 0) {
    fun delta(a: Int, b: Int, c: Int): Int = (b * b) - 4 * a * c
    val deltaValue = delta(a, b, c)

    val result =
            when {
              deltaValue > 0 -> "Two distinct real roots"
              deltaValue == 0 -> "One real root"
              deltaValue < 0 -> "Complex roots"
              else -> "Unexpected case"
            }

    println("Delta: $deltaValue, Result: $result")

    if (deltaValue > 0) {
      val (root1, root2) =
              rootFinder(a.toDouble(), b.toDouble(), c.toDouble(), deltaValue.toDouble())!!
      println("Root 1: $root1")
      println("Root 2: $root2")
    } else if (deltaValue == 0) {
      val root =
              rootFinder(a.toDouble(), b.toDouble(), c.toDouble(), deltaValue.toDouble())?.first!!
      println("Root: $root")
    }
  } else {
    println("Invalid input, please try again with non-zero values.")
  }
}

fun rootFinder(a: Double, b: Double, c: Double, deltaValue: Double): Pair<Double, Double>? {
  if (deltaValue > 0) {
    val root1 = (-1 * b + Math.sqrt(deltaValue)) / (2 * a)
    val root2 = (-1 * b - Math.sqrt(deltaValue)) / (2 * a)
    return Pair(root1, root2)
  } else if (deltaValue == 0.0) {
    val root = (-b) / (2 * a)
    return Pair(root, root)
  } else {
    return null
  }
}

// The main Code -s Kotlin - EX 1
// Soheil Fouladvani
fun main() {
  print("Enter Coefficient(a,b,c): ")
  // Get USER input & Split it
  val userInput = readLine()
  val arrayMaker = userInput?.split(",")?.map { it.trim().toInt() }?.toTypedArray()?.toIntArray()

  if (arrayMaker != null) {
    algorithm(a = arrayMaker[0], b = arrayMaker[1], c = arrayMaker[2])
  } else {
    println("Invalid input format. Please enter three numbers separated by commas.")
  }
}
