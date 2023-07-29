/*
 * Copyright (c) 2011-2021, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.controls.tableview

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{TableColumn, TableView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle

/** Illustrates use of TableColumn CellFactory to do custom rendering of a TableCell. */
object TableWithCustomCellDemo extends JFXApp3 {

  private val characters = ObservableBuffer[Person](
    new Person("Peggy", "Sue", "555-6798", Color.Violet),
    new Person("Rocky", "Raccoon", "555-6798", Color.GreenYellow),
    new Person("Bungalow ", "Bill", "555-9275", Color.DarkSalmon)
  )

  override def start(): Unit = {
    stage = new PrimaryStage {
      title = "TableView with custom color cell"
      scene = new Scene {
        root = new TableView[Person](characters) {
          columns ++= Seq(
            new TableColumn[Person, String] {
              text = "First Name"
              cellValueFactory = _.value.firstName
            },
            new TableColumn[Person, String]() {
              text = "Last Name"
              cellValueFactory = _.value.lastName
            },
            new TableColumn[Person, Color] {
              text = "Favorite Color"
              // What should be used as the value of the cell
              cellValueFactory = _.value.favoriteColor
              // How the value should be displayed in the cell
              cellFactory = (cell, color) => {
                cell.graphic = Circle(fill = color, radius = 8)
              }
            }
          )
        }
      }
    }
  }
}
