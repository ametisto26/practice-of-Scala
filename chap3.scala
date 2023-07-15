val big = new java.math.BigInteger("12345")

val greetStrings = new Array[String](3) //非推奨な方法
//val greetStrings: Array[String] = new Array[String](3) とすれば型を明示できる

greetStrings(0) = "Hello" //greetStrings.update(0, "Hello")
greetStrings(1) = ", " //greetStrings.update(1, ", ")
greetStrings(2) = "world!\n" //greetStrings.update(2, "world!\n")

for (i <- 0 to 2) //for (i <- 0.to(2))
    print(greetStrings(i)) //print(greetStrings.apply(i))

//    1+2 == (1).+(2) +がメソッド呼び出しであることを確認できる。


val numNames = Array("zero", "one", "two")
val numNames2 = Array.apply("zero", "one", "two")


val oneTwoThree = List(1, 2, 3)
val oneTwo = List(1, 2)
val threeFour = List(3, 4)

val oneTwoThreeFour = oneTwo ::: threeFour

println(oneTwoThreeFour)

val twoThreeFour = 2 :: threeFour // :: は cons と読むらしい
println(twoThreeFour)

val oneTwoThreeFourFive = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

