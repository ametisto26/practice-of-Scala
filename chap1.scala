def factorial(x: BigInt): BigInt = {
    if(x == 0) 1 else x * factorial(x - 1)
}

factorial(30)

/*
import java.math.BigInteger
def factorial(x: BigInteger): BigInteger =
    if(x == BigInteger.ZERO)
      BigInteger.ONE
    else
      x.multiply(factrial(x.subtract(BigInteger.ONE)))
 */

