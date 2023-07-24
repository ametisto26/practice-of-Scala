//Non negative integer
//object Calculator extends App {
       def add(a: BigInt, b: BigInt): BigInt = { // a + b
              a + b
       }
       def sub(a: BigInt, b: BigInt): BigInt = { // a - b
              if(a < b) - sub(b, a)
              else if (a == b) 0
              else {
                     1 + sub(a, b + 1)
              }
       }
       def mul(a: BigInt, b: BigInt): BigInt = {// a * b
              if(b == 1) a 
              else a + mul(a, sub(b,1))
       }
       def div(a: BigInt, b: BigInt): BigInt = {// a / b
              if(a == b) 1 
              else if(a < b) 0 //余りは切り捨てる。
              else 1 + div(sub(a, b), b)
       }
//}
