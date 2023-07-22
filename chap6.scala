//nが分子，dが分母である。

class Rational(n: Int, d: Int) { 
       require(d != 0) //d != 0 を要請している。
       val numer: Int = n
       val denom: Int = d
       // println("Created " + n + "/" + d)
       override def toString = s"$n/$d"
       def add(that: Rational): Rational = {
              new Rational(numer * that.denom +that.numer * denom, denom * that.denom)
       }
}

//import scala.language.postfixOps

val q1 = new Rational(1, 2)
val q2 = new Rational(2, 3)

val q3 = q1 add q2

q1.numer
q1.denom
