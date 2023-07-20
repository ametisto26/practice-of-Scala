val hex = 0x5
val hex2 = 0x00ff
val hex3 = 0xCafebabe

val dec1 = 31
val dec2 = 255
val dec3 = 20

val prog = 0xcafebabeL
val tower = 333l
val of = 31L

val little: Short = 333
val little2: Byte = 31

val big = 1.2345
val big2 = 1.2345e1
val big3 = 123e45 //1.23E47

val bigF = 1.2345f
val bigF2 = 3E5F

val bigA = 3E5
val bigA2 = 3e5D
val bigA3 = 6e14d


//文字
val a = 'A'
val a2 = '\u0041'
val a3 = '\u0044'
val a4 = '\u0040'

val backslash = '\\'


//文字列
val hello = "hello"
val escapeS = "\\\"\'"
val ssss = """\\\"\'"""

println("""Hello! Are you READY?
              Type "y" or "n" for next step.""")

println("""| Hello! Are you READY?
              | Type "y" or "n" for next step.""".stripMargin)

//シンボル
val s = Symbol("Ametisto")
val nm = s.name
val nm = s

//Boolean
val t = true
val f = false
