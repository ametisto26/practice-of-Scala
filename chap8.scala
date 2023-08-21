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

