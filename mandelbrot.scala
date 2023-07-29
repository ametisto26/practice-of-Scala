package mandelbrot

import scala.collection.mutable.ArraySeq

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.{BorderPane, HBox, Priority}
import scalafx.scene.paint.Color

import complex.Complex

object Model {
       val W = 500
       val H = 500

       type Region = (Complex, Complex)
       type History = (List[Region], Int)
       var history = {
              val c1 = new Complex(-2, -2)
              val c2 = new Complex(2, 2)
              (List((c1, c2)), 0)
       }

       def currentRegion(h: History) = h._1(h._2)
       def dropToCurrent(h: History) = h._1.drop(h._2)

       var favorites: List[Region] = Nil

       def complex(h: History, x: Double, y: Double): Complex = {
              currentRegion(h) match {
                     case (c1, c2) => {
                            val re = (c1.re * (W - x) + c2.re * x) / W
                            val im = (c1.im * (H - y) + c2.im * y) / H
                            new Complex(re, im)
                     }
              }
       }

       var p1: Complex = new Complex(0, 0)

       def subRegion(h: History, p1: Complex, p2: Complex) = {
              currentRegion(h) match {
                     case (c1, c2) => {
                            val size = math.max(math.abs(p2.re - p1.re), math.abs(p2.im - p1.im))
                            val _re1 = (p1.re + p2.re - size) / 2
                            val _im1 = (p1.im + p1.im - size) / 2
                            val re1 = math.min(math.max(c1.re, _re), c2.re - size) / 2
                            val im1 = math.min(math.max(c1.im, _im), c2.im - size) / 2

                            ((new Complex(re1, im1), new Complex(re1 + size, im1 + size)) :: dropToCurrent(h), 0)
                     }
              }
       }

       def onDragStart(e: MouseEvent) { p1 = complex(history, e.x, e.y) }
       def onDragFinish(e: MouseEvent) { update(subRegion(history, p1, complex(history, e.x, e.y))) }

       def onQuit() {
              println("終了します。")
              println(f"#お気に入り" = ${favorites.length})
              for (region <- favorites) println(region)
              System.exit(0)
       }
       
       def update(h: History) { history = h }

       def backward(h: History) = {
              if (h._2 < h._1.length - 1) { ((h._1, h._2 + 1), true) }
              else { (h, true) }
       }

       def theTitle() = f"Mandelbrot's microscope (${currentRegion(history)})"


       val NUMCOLOR = 256
       val colors: ArraySeq[Color] = {
              ArraySeq.tabulate(NUMCOLOR){
                     i => 
                     Color.hsb(30, 1,
                     if (i == NUMCOLOR - 1) 1.0
                     else ( (i << 2) % NUMCOLOR) / NUMCOLOR.toDouble
                     )
              }
       }

       def color(x: Int, y: Int): Color = {
              val c = complex(history, x, y)
              val z = new Complex(0, 0)
              val n = 0
              while (n < (NUMCOLOR - 1) && z.abs <= 2) {
                     z = z * z + c
                     n += 1
              }
              colors(n)
       }
}



