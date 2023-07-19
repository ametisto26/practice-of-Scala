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
println(oneTwoThreeFourFive)


//tuple 
val pair = (26, "Ametisto")
println(pair._1)
println(pair._2)

val point = Tuple22(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22)
//val point = Tuple23(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23)

//immutable set
var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
println(jetSet.contains("Cessna"))

//mutable set
import scala.collection.mutable
val langSet = mutable.Set("Scala", "Python")
langSet += "Rust"
println(langSet)

import scala.collection.immutable.HashSet
val hashSet = HashSet("Tomatoes", "Chilies")
println(hashSet + "Coriander")


//mutable map
import scala.collection.mutable
val treasureMap = mutable.Map[Int, String]()
treasureMap += (1, "Go to the island.")
treasureMap += (2, "Find big X on ground.")
treasureMap += (3, "Dig.")
println(treasureMap(2)) //出力は"Find big X on ground."のはずである。

//immutable map
val romanNumeral = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)
println(romanNumeral(4)) //出力は"IV"のはずである。

