package complex

//import scala.math

class Complex(_re: Double, _im: Double) {
       def re = _re
       def im = _im
       
       def add(c: Complex): Complex = { 
              new  Complex(_re + c.re, _im + c.im)
       }
       def sub(c: Complex): Complex = { 
              new  Complex(_re - c.re, _im - c.im)
       }
       def mul(c: Complex): Complex = { 
              new  Complex(_re * c.re - _im * c.im, c.re * _im + _re * c.im)
       }
       // def div(c: Complex): Complex = { 

       // }

       def abs = math.sqrt(re * re + im * im)

       def conj = new Complex(re, - im)
       def neg = new Complex(-re, -im)

       override def toString(): String = {
              if (im >= 0) f"$re%f +$im%fi"
              else f"$re%f $im%fi"
       }

       def +(c: Complex) = add(c)
       def +(a: Double) = new Complex(re + a, im)

       def -(c: Complex) = sub(c)
       def -(a: Double) = new Complex(re - a, im)

       def unary_- = neg

       def *(c: Complex) = mul(c)
       def *(a: Double) = new Complex(re * a, im * a)
       
       def equals(c: Complex) = {
              re == c.re && im == c.im
       }
       def equals(a: Double) = {
              this == new Complex(a, 0)
       }
       




}

