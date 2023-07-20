//行の読み出し
//scala .\countchars1.scala countchars1.scala

import scala.io.Source

object counting {
       def main(args: Array[String]) = {
              if (args.length > 0) {
                     for (line <- Source.fromFile(args(0)).getLines())
                            println(line.length.toString + " | " + line)
              }
              else {
                     Console.err.println("Please enter filename.")       
              }
       }
}