object Mag extends App {
       def dog(n: Int): Int = {
              ((n + 4) * 2 - 6) / 2 - n
       }

       for(i <- 1 to 13){ //どうせすべて１になる。
              println(s"$i : ${dog(i)}")
       }
}