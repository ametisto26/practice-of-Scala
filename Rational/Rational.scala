//Class of rational numbers

class Rational(n: Int, d: Int) { 
       require(d != 0) //d != 0 を要請している。

       private val g = gcd(n.abs, d.abs)
       val numer = n / g
       val denom = d / g

       def this(n: Int) = this(n, 1) //補助コンストラクタ

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
}

implicit def intToRational(x: Int): Rational = new Rational(x) //暗黙の型変換
