object Mag extends App {
       def dog(n: Int): Int = {
              ((n + 4) * 2 - 6) / 2 - n
       }

       for(i <- -50 to 50){
              println(s"$i : ${dog(i)}")
       }
}