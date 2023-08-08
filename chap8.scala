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
