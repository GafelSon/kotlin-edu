fun harmonicSeries(n: Int) {
  var s: Double = 0.0
  for (i in 1..n) {
    val div = 1.0 / i
    println("$div + ")
    s += 1.0 / i
  }
  println("The sum of the harmonic series up to $n is: $s")
}

fun main() {
  // for n = 100
  harmonicSeries(100)
}
