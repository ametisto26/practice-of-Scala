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

var line = readLine() // 何か入力すると始まり，何も入力しないままEnterで終わる。
while (line != "") {
       line = readLine()
       println("Read: " + line)
}


def greet() = { println("Yo")}
val whatAmI = greet()
