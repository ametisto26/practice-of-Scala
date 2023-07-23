//nが分子，dが分母である。

class Rational(n: Int, d: Int) { 
       require(d != 0) //d != 0 を要請している。

       private val g = gcd(n.abs, d.abs)
       val numer = n / g
       val denom = d / g

       def this(n: Int) = this(n, 1) //補助コンストラクタ

       // println("Created " + n + "/" + d)
       override def toString = s"$numer/$denom"

       private def gcd(a: Int, b: Int): Int = 
              if (b == 0) a else gcd(b, a % b)

       def +(that: Rational): Rational = {
              new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
       }

       def +(i: Int): Rational =
              new Rational(numer + i * denom, denom)


       def -(that: Rational): Rational = {
              new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
       }

       def -(i: Int): Rational =
              new Rational(numer - i * denom, denom)

       def *(that: Rational): Rational = {
              new Rational(numer * that.numer, denom * that.denom)
       }

       def *(i: Int): Rational =
              new Rational(numer * i, denom)

       def /(that: Rational): Rational = {
              new Rational(numer * that.denom, denom * that.numer)
       }

       def /(i: Int): Rational =
              new Rational(numer, denom * i)

       def lessThan(that: Rational) =
              this.numer * that.denom < that.numer * this.denom
       
       def max(that: Rational) = 
              if (this.lessThan(that)) that else this
}

implicit def intToRational(x: Int): Rational = new Rational(x) //暗黙の型変換

//import scala.language.postfixOps

val q1 = new Rational(1, 2)
val q2 = new Rational(2, 3)

val q3 = q1 + q2
val q4 = q1 * q2

q1.numer
q1.denom

q1 lessThan q2 //true
q1 max q2 // q2

val z1 = new Rational(5)

val q4 = new Rational(42, 66)
