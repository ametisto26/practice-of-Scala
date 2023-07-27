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

def grep(pattern: String) = {
       for (
              file <- filesHere
              if (file.getName.endsWith(".scala"));
              line <- fileLines(file)
              if (line.trim.matches(pattern))
       )
       println(s"$file: ${line.trim}")
}
grep(".*gcd.*")

