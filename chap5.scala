//数値
val hex = 0x5
val hex2 = 0x00ff
val hex3 = 0xCafebabe

val dec1 = 31
val dec2 = 255
val dec3 = 20

val prog = 0xcafebabeL
val tower = 333l
val of = 31L

val little: Short = 333
val little2: Byte = 31

val big = 1.2345
val big2 = 1.2345e1
val big3 = 123e45 //1.23E47

val bigF = 1.2345f
val bigF2 = 3E5F

val bigA = 3E5
val bigA2 = 3e5D
val bigA3 = 6e14d


//文字
val a = 'A'
val a2 = '\u0041'
val a3 = '\u0044'
val a4 = '\u0040'

val backslash = '\\'


//文字列
val hello = "hello"
val escapeS = "\\\"\'"
val ssss = """\\\"\'"""

println("""Hello! Are you READY?
              Type "y" or "n" for next step.""")

println("""| Hello! Are you READY?
              | Type "y" or "n" for next step.""".stripMargin)

//シンボル
val s = Symbol("Ametisto")
val nm = s.name
val nm = s

//Boolean
val t = true
val f = false


//文字列補間
val nameOfReader = "John Doe"
println(s"Hello, $nameOfReader!")

s"The answer is ${5 * 3}"

//import math.scala
f"${math.Pi}"
f"${math.Pi}%.10f"
f"${math.Pi}%15.10f"
f"${math.Pi}%.17f" //あまり意味がない指定

println(s"No\\\\escape!") //No\\escape!
println(raw"No\\\\escape!") //No\\\\escape!
println(f"No\\\\escape!") //No\\escape!

val pi = "Pi"
println(f"${pi} is approximately ${math.Pi}%.5f.")


//演算子（算術演算子）
val sum = 1 + 2
val b = sum == 1.+(2)

val sumLong = 1 + 2L
val b = sum == 1.+(2L)

val str = "Hello, World!"
str indexOf "," // ',' でも動く。

str indexOf 'o' //Scala は str.indexOf('o')を呼び出す。
str indexOf ('o', 4)
str indexOf ('o', 5)

str.indexOf('W')

import scala.language.postfixOps
val strlower = str toLowerCase
val strCapit1 = str capitalize
val strCapit2 = strlower capitalize

val a = -2.02
val a2 = (2.02).unary_-
a == a2

1 + 2.3
3 - 1
'b' - 'a'
//"c" - "b"
5L - 4
8L * 6l
11 / 4
11 / 4.0
11 % 4
11 % 4.0
11 % 4f

math.IEEEremainder(11, 4) //-1.0

val neg = 1 + -3
-neg

//関係演算子
1 > 1
1 < 2
3.5f < 3.6f
5L <= 5d
'a' > 'A'
val utrue = !true

//論理演算子
def salt() = {println("salt"); false}
def pepper() = {println("pepper"); true}

pepper() && salt()
salt() && pepper()

pepper() & salt()
salt() & pepper()

pepper() || salt()
salt() || pepper()

pepper() | salt()
salt() | pepper()


//ビット単位演算子
1 & 2
1 | 2
1 ^ 3
~1 //単項演算子

1 << 2
-1 >> 31
-1 >>> 31 //符号なし


//等価性
1 == 2 //false
1 != 2
3 == 3
1 == 1L //true
1d == 1l //true

List(1, 2, 3) == List(1, 2, 3)
List("Hello") == null
List() == Nil

2 << 4
2 << 2 + 2
2 + 2 << 2
1 + 1 << 4

//リッチ演算
5 max 7
5 min 0
//-2.213 abs
//-2.6 round
//5e33 isInfinity
4 to 8
