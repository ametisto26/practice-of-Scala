//Chapter 2

//同じ行に出力する。
def printargs(args: Array[String]) = {
  var i = 0  //val args = "k" : Array[String]
  while (i < args.length) {
    if(i != 0){
      print(" ")
    }
    print(args(i))
    i += 1
  }
  println()
}
