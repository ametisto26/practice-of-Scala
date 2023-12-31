import scala.io.Source

object LongLines {
       def processFile(filename: String, width: Int) = {
              val source = Source.fromFile(filename)
              for (line <- source.getLines())
                     processLine(filename, width, line)
       }

       private def processLine(filename: String, width: Int, line: String) = {
              if (line.length > width)
                     println(filename + ": " + line.trim)
       }
}

// object FindLongLines {
//        def main(args: Array[String]) = {
//               val width = args(0).toInt
//               for (arg <- args.drop(1))
//                      LongLines.processFile(arg, width)
//        }
// }


import scala.io.Source

object LongLines {
       def processFile(filename: String, width: Int) = {
              def processLine(line: String) = {
                     if (line.length > width)
                            println(filename + ": " + line.trim)
              }
              val source = Source.fromFile(filename)
              for (line <- source.getLines())
                     processLine(line)
       }
}


// 関数リテラル
(x: Int) => x + 1

var increase = (x: Int) => x + 1
increase(10)

increase = (x: Int) => x + 2525 // increase が var ゆえに可能 
increase(10)

increase = (x: Int) => {
       println("Hello!")
       x + 9999
}
increase(10)

// foreach メソッド　詳しくはchap17を参照
val someNum = List(-11, 50, 64, -6, 20, 26)
someNum.foreach((x: Int) => println(x))

//filter メソッド
someNum.filter((x: Int) => x > 20)


//関数リテラルの短縮形
val someNum = List(-11, 50, 64, -6, 20, 26)
someNum.foreach((x) => println(x)) // 型を省略

someNum.filter(x => x > 20) // 推論で型が分かるパラメータを囲むかっこは省略可能


//プレースホルダー構文
val someNum = List(-11, 50, 64, -6, 20, 26)
someNum.foreach(println(_)) // 型を省略

someNum.filter(_ > 20) 


val f = (_: Int) + (_: Int) // _ + _ と書くとエラーになる

f(2, 5)


//部分的に適用された関数
//関数が必要とする引数を完全には渡していない関数呼び出し
val someNum = List(-11, 50, 64, -6, 20, 26)
someNum.foreach(println _) // 空白を残す

def sum(a: Int, b: Int, c: Int) = a + b + c
val paf = sum _
paf(1, 2, 3)
paf.apply(1, 2, 3)

val paf2 = sum(1, _: Int, 3)
paf2(3)


// これも可能
val someNum = List(-11, 50, 64, -6, 20, 26)
someNum.foreach(println) // 空白を残す


// クロージャー
var more = 5
val addMore = (x: Int) => x + more
// 先述の val a = (x: Int) => x + 1 は閉項（closed term）と呼ばれる
// これに対して val addMore = (x: Int) => x + more は開項（open term）と呼ばれる。
addMore(10) // 関数値をクロージャーと呼ぶ。

more = 9990 // more を変更
addMore(10) // 10000 と出力される
addMore(100) // 10090 と出力される（x を変更）

// まわりくどい方法で総和を求める
val someNum = List(-11, 50, 64, -6, 20, 26)
var sum = 0

someNum.foreach(sum += _)

println(sum) // 総和


//連続パラメーター

//関数の最後のパラメータが繰り返されることの指定
def echo(args: String*) = {
       for (arg <- args) println(arg)
}

echo()
echo("One")
echo("One", "Two", "Three")

val seqst = Seq("a", "b", "c")
echo(seqst) // エラー
echo(seqst: _*) // Seq の個々の要素を引数として渡すことの明示


// 名前付き引数
def speed(distance: Double, time: Double): Double = {
       distance / time
}

speed(100, 10)
speed(time = 10, distance = 100)
speed(100, 10) == speed(time = 10, distance = 100)

// パラメーターのデフォルト値
def printTime(out: java.io.PrintStream = Console.out) = { // デフォルト値が1個
       out.println("time = " + System.currentTimeMillis())
}

printTime()
printTime(Console.err) //　標準エラー出力にログを送り込む

def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) = { // デフォルト値が2個
       out.println("time = " + System.currentTimeMillis() / divisor)
}

printTime2()
printTime2(out = Console.err)
printTime2(Console.err)
printTime2(divisor = 1000)


def boom(n: Int): Int = {
       if (n == 0) throw new Exception("Boom!")
       else boom(n - 1) + 1
}

def bang(n: Int): Int = { // 末尾再起
       if (n == 0) throw new Exception("Bang!")
       else bang(n - 1)
}


// 以下は最適化されない
def isEven(n: Int): Boolean = {
       if (n == 0) true 
       else isOdd(n - 1)       
} 

def isOdd(n: Int): Boolean = {
       if (n == 0) false 
       else isEven(n - 1)
}


val funValue = nestedFun_
def nestedFun(x: Int): Unit = {
       if (x != 0) {
              println(x)
              funValue(x - 1)
       }
}


