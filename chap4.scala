class ChecksumAccumulatorSample {
       //Write the definition of this class here.
       var sum = 0
}

val acc = new ChecksumAccumulatorSample
val csa = new ChecksumAccumulatorSample

acc.sum = 3
//acc = new ChecksumAccumulatorSample はエラーとなる。

class ChecksumAccumulatorSample2 {

       private var sum = 0

       def add(b: Byte): Unit = {
              sum += b
       }

       def checksum(): Int = {
              return  ~(sum & 0xFF) + 1
       }
}


class ChecksumAccumulator { //完成版
       private var sum = 0
       def add(b: Byte): Unit = { sum += b }
       def checksum(): Int = ~(sum & 0xFF) + 1
}


//セミコロン推論
val aa = "hello"; println(aa)

//x + y を2行にする場合
/*
(x
+ y)
または
x +
y
とすれば良い。
*/


//singleton object


