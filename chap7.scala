// val filename = "default.txt"
// if (!args.isEmpty) filename = args(0)

// val filename = 
//        if (!args.isEmpty) args(0)
//        else "default.txt"

def gcdLoop(x: Long, y: Long): Long = {
       var a = x
       var b = y
       while (a != 0) {
              val temp = a
              a = b % a 
              b = temp
       }
       b
}

def gcd(x: Long, y: Long): Long = 
       if (y == 0) x else gcd(y, x % y)

//do-while は Scala3 ではサポート外
// var line = ""
// do {
//        line = readLine()
//        println("Read: " + line)
// } while (line != "")

import scala.io.StdIn.readLine

var line = readLine() // 何か入力すると始まり，何も入力しないままEnterキーを押すと終わる。
while (line != "") {
       line = readLine()
       println("Read: " + line)
}


def greet() = { println("Yo")}
val whatAmI = greet()


// for
val filesHere = (new java.io.File(".")).listFiles
for (file <- filesHere)
       println(file) //出力を確認する。

for (i <- 1 to 5)
       println("Iteration" + i)

for (i <- 1 until 5)
       println("Iteration" + i)

// Scala ではあまり見ない for の使い方
for (i <- 0 to filesHere.length - 1)
       println(filesHere(i))


// filter
for (file <- filesHere if file.getName.endsWith(".scala"))
       println(file) 

//上と同じ出力を得る。
for (file <- filesHere)
       if (file.getName.endsWith(".scala"))
              println(file) 

//複数の場合
for (
       file <- filesHere
       if file.isFile //() ディレクトリを除くためのもの（この場合は実質無意味である）
       if file.getName.endsWith(".scala")
       )
       println(file) 


// forのネスト
val filesHere = (new java.io.File(".")).listFiles

def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toArray

// def grep(pattern: String) = {
//        for (
//               file <- filesHere
//               if (file.getName.endsWith(".scala"));
//               line <- fileLines(file)
//               if (line.trim.matches(pattern))
//        )
//        println(s"$file: ${line.trim}")
// }
// grep(".*gcd.*")


// for{} and bind
def grep(pattern: String) = {
       for {
              file <- filesHere
              if file.getName.endsWith(".scala")
              line <- fileLines(file)
              trimmed = line.trim
              if trimmed.matches(pattern)
       }
       println(s"$file: $trimmed")
}
grep(".*gcd.*")


// for [generator] yield [main]
def scalaFiles = {
       for {
              file <- filesHere
              if file.getName.endsWith(".scala")
       }
       yield file
}
scalaFiles

/* これはエラーになる。
def scalaFiles = {
       for {
              file <- filesHere
              if file.getName.endsWith(".scala")
       }
       {
              yield file
       }
}
*/

val forLineLength = {
       for {
              file <- filesHere
              if file.getName.endsWith(".scala")
              line <- fileLines(file)
              trimmed = line.trim
              if trimmed.matches(".*for.*")
       }
       yield trimmed.length
}



// 例外
//throw new IllegalArgumentException

import scala.io.StdIn.readLine
var n = readLine().toInt

val half = {
       if (n % 2 == 0) n / 2
       else throw new RuntimeException("n must be even")
}



// 例外のキャッチ
// try-catch
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

try {
       val f = new FileReader("input.txt") // ファイルを使ってクローズする。
} catch {
       case ex: FileNotFoundException => // Not exist
       case ex: IOException => // I/O Error
}


// try-finally
import java.io.FileReader

val file = new FileReader("input.txt")
try {
       // use the file
} finally { 
       file.close() //確実にファイルをクローズする。
}


// 値を生成するcatch
import java.net.URL
import java.net.MalformedURLException

def urlFor(path: String) = {
       try {
              new URL(path)
       } catch {
              case e: MalformedURLException => new URL("https://www.scala-lang.org")
       }
}


//実験用
def f(): Int = try return 1 finally return 2 // 結果値は2になる。
def g(): Int = try 1 finally 2 // 結果値は1になる。


// 副作用のあるmatch
val firstArg = if (args.length > 0) args(0) else "" //　このままではエラーになる。

firstArg match {
       case "salt" => println("pepper")
       case "chips" => println("salsa")
       case "eggs" => println("bacon")
       case _ => println("huh?")
}


// 結果値を生成するmatch
val firstArg = if (!args.isEmpty) args(0) else "" //　このままではエラーになる。

val friend =
       firstArg match {
              case "salt" => "pepper"
              case "chips" => "salsa"
              case "eggs" =>  "bacon"
              case _ => "huh?"
       }

println(friend)


